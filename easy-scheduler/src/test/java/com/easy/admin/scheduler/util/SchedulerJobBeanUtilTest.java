package com.easy.admin.scheduler.util;

import com.easy.admin.scheduler.model.SchedulerJobParamOption;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SchedulerJobBeanUtilTest {

    @Test
    void buildParamsShouldMapSupportedTypes() throws Exception {
        Method method = SignatureSample.class.getMethod(
                "sampleJobWithParams",
                String.class,
                Integer.class
        );
        List<SchedulerJobParamOption> params = invokeBuildParams(method);

        assertEquals(2, params.size());
        assertEquals("String", params.get(0).getType());
        assertEquals("", params.get(0).getValue());
        assertEquals("Integer", params.get(1).getType());
        assertEquals("0", params.get(1).getValue());
    }

    @Test
    void buildSignatureShouldIncludeParameterTypes() throws Exception {
        Method method = SignatureSample.class.getMethod(
                "sampleJobWithParams",
                String.class,
                Integer.class
        );
        String signature = invokeBuildSignature(method);

        assertEquals("sampleJobWithParams(String, Integer)", signature);
    }

    @SuppressWarnings("unchecked")
    private List<SchedulerJobParamOption> invokeBuildParams(Method method) throws Exception {
        var buildParams = SchedulerJobBeanUtil.class.getDeclaredMethod("buildParams", Class[].class);
        buildParams.setAccessible(true);
        return (List<SchedulerJobParamOption>) buildParams.invoke(null, (Object) method.getParameterTypes());
    }

    private String invokeBuildSignature(Method method) throws Exception {
        var buildSignature = SchedulerJobBeanUtil.class.getDeclaredMethod(
                "buildSignature",
                String.class,
                Class[].class
        );
        buildSignature.setAccessible(true);
        return (String) buildSignature.invoke(null, method.getName(), method.getParameterTypes());
    }

    static class SignatureSample {

        public void sampleJob1() {
        }

        public void sampleJobWithParams(String name, Integer count) {
        }
    }
}
