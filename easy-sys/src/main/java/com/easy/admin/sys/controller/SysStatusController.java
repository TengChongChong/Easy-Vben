package com.easy.admin.sys.controller;

import cn.hutool.system.*;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统状态
 *
 * @author TengChongChong
 * @date 2021/01/04
 */
@RestController
@RequestMapping("/api/auth/sys/status")
@ResponseResult
public class SysStatusController {

    /**
     * Java Virtual Machine Specification信息
     *
     * @return JvmSpecInfo
     */
    @GetMapping("jvm/spec/info")
    public JvmSpecInfo getJvmSpecInfo() {
        return SystemUtil.getJvmSpecInfo();
    }

    /**
     * Java Virtual Machine Implementation信息
     *
     * @return JvmInfo
     */
    @GetMapping("jvm/info")
    public JvmInfo getJvmInfo() {
        return SystemUtil.getJvmInfo();
    }

    /**
     * Java Specification信息
     *
     * @return JavaSpecInfo
     */
    @GetMapping("java/spec/info")
    public JavaSpecInfo getJavaSpecInfo() {
        return SystemUtil.getJavaSpecInfo();
    }

    /**
     * Java Implementation信息
     *
     * @return JavaInfo
     */
    @GetMapping("java/info")
    public JavaInfo getJavaInfo() {
        return SystemUtil.getJavaInfo();
    }

    /**
     * Java运行时信息
     *
     * @return JavaRuntimeInfo
     */
    @GetMapping("java/runtime/info")
    public JavaRuntimeInfo getJavaRuntimeInfo() {
        return SystemUtil.getJavaRuntimeInfo();
    }

    /**
     * 系统信息
     *
     * @return OsInfo
     */
    @GetMapping("os/info")
    public OsInfo getOsInfo() {
        return SystemUtil.getOsInfo();
    }

    /**
     * 用户信息
     *
     * @return UserInfo
     */
    @GetMapping("user/info")
    public UserInfo getUserInfo() {
        return SystemUtil.getUserInfo();
    }

    /**
     * 当前主机网络地址信息
     *
     * @return HostInfo
     */
    @GetMapping("host/info")
    public HostInfo getHostInfo() {
        return SystemUtil.getHostInfo();
    }

    /**
     * 运行时信息，包括内存总大小、已用大小、可用大小等
     *
     * @return RuntimeInfo
     */
    @GetMapping("runtime/info")
    public RuntimeInfo getRuntimeInfo() {
        return SystemUtil.getRuntimeInfo();
    }
}
