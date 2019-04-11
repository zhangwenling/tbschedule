package com.taobao.console.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

@Component
public class SpringConfigTool implements ApplicationContextAware {//extends ApplicationObjectSupport{

    private static ApplicationContext context = null;
    private static SpringConfigTool stools = null;

    public synchronized static SpringConfigTool init() {
        if (stools == null) {
            stools = new SpringConfigTool();
        }
        return stools;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        SpringConfigTool.context = context;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
        System.out.println("context注入成功");
    }

    public synchronized static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

}