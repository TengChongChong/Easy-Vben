package com.easy.admin.config.shiro.config;

import com.easy.admin.config.shiro.SessionManager;
import com.easy.admin.config.shiro.ShiroRealm;
import com.easy.admin.config.shiro.cache.RedisCacheManager;
import com.easy.admin.config.shiro.check.RetryLimitCredentialsMatcher;
import com.easy.admin.config.shiro.filter.CheckSessionFilter;
import com.easy.admin.config.shiro.session.RedisSessionDAO;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.*;

/**
 * Shiro配置
 *
 * @author TengChongChong
 * @date 2018/9/4
 */

@Configuration
public class ShiroConfig {

    /**
     * 记住我cookie
     */
    public static final String REMEMBER_ME = "rememberMe";

    /**
     * cookie加密的密钥
     * 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
     */
    public static final String REMEMBER_ME_SECRET_KEY = "XPgE3lrQuxfE3tBEnU/7iQ==";

    /**
     * 记住我过期时间 默认30天 单位: 秒
     */
    @Value("${project.login.remember.invalidate-time}")
    private final Integer loginRememberInvalidateTime = 259200;

    /**
     * 设置session失效的扫描时间, 清理用户直接关闭浏览器造成的孤立会话
     */
    @Value("${project.session-validation-interval}")
    private final Integer sessionValidationInterval = 86400;

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(SecurityManager securityManager) {
        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        bean.setArguments(securityManager);
        return bean;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 设置过滤规则
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //注意此处使用的是LinkedHashMap，是有顺序的，shiro会按从上到下的顺序匹配验证，匹配了就不再继续验证
        //所以上面的url要苛刻，宽松的url要放在下面，尤其是"/**"要放到最下面，如果放前面的话其后的验证规则就没作用了。
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 自定义拦截
        Map<String, Filter> customFilter = new HashMap<>(1);
        // 检查会话
         customFilter.put("checkSession", new CheckSessionFilter());
        shiroFilterFactoryBean.setFilters(customFilter);

        /*
         * anon   匿名拦截器,不需要登录即可以访问 一般用于静态资源
         * authc  需要身份验证才能访问 验证未通过跳转到登录页面
         * logout 退出
         * user   表示用户不一定已通过认证,只要曾被Shiro记住过登录状态的用户就可以正常发起请求,比如rememberMe
         */
        // 检查会话
        filterChainDefinitionMap.put("/api/auth/**", "checkSession");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(redisCacheManager());

        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());

        // 注入记住我管理器
        securityManager.setRememberMeManager(rememberMeManager());

        // 设置realm.
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(credentialsMatcher());
        return shiroRealm;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * cacheManager 缓存 redis实现
     *
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager() {
        return new RedisCacheManager();
    }

    @Bean
    public SessionDAO sessionDAO() {
        return new RedisSessionDAO();
    }
    
    /**
     * shiro session的管理
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        SessionManager sessionManager = new SessionManager();
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO());

        Collection<org.apache.shiro.session.SessionListener> sessionListeners = new ArrayList<>();
        sessionManager.setSessionListeners(sessionListeners);

        //全局会话超时时间 单位: 毫秒,默认30分钟
        sessionManager.setGlobalSessionTimeout(30 * 60 * 1000);

        //是否开启删除无效的session对象 默认为true
        sessionManager.setDeleteInvalidSessions(true);
        //是否开启定时调度器进行检测过期session 默认为true
        sessionManager.setSessionValidationSchedulerEnabled(true);
        //设置session失效的扫描时间, 清理用户直接关闭浏览器造成的孤立会话 默认为 30分钟
        sessionManager.setSessionValidationInterval(sessionValidationInterval * 1000L);

        //取消url 后面的 JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * cookie对象
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等
     *
     * @return SimpleCookie
     */
    private SimpleCookie rememberMeCookie() {
        // 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie(REMEMBER_ME);
        // 防止跨站脚本
        simpleCookie.setHttpOnly(true);
        // 记住我cookie生效时间30天,不设置默认永不过期 单位: 秒
        simpleCookie.setMaxAge(loginRememberInvalidateTime);
        return simpleCookie;
    }

    /**
     * 凭证匹配器
     *
     * @return true/false
     */
    @Bean
    public RetryLimitCredentialsMatcher credentialsMatcher() {
        return new RetryLimitCredentialsMatcher();
    }

    /**
     * cookie管理对象;记住我功能
     *
     * @return CookieRememberMeManager
     */
    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe
        cookieRememberMeManager.setCipherKey(Base64.decode(REMEMBER_ME_SECRET_KEY));
        return cookieRememberMeManager;
    }
}