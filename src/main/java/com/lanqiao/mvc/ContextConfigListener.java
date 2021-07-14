package com.lanqiao.mvc;

/**
 * @Author liwei
 * @Date 2020/9/5 10:57
 * @Version 1.0
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Servlet3.0版本后支持注解方式实现监听器
 */
//@WebListener()
public class ContextConfigListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public ContextConfigListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        try {
            Map<String, ControllerMapping> controllerMapping = new Configuration().config();
            /*
            request：请求 session：会话 application：全局作用域
             */
            sce.getServletContext().setAttribute("com.lanqiao.controller", controllerMapping);
            Class.forName("com.lanqiao.ioc.BeanFactory");//将beanfactory这个类一开始就加载执行
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }
}