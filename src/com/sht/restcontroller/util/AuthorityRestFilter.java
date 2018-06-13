package com.sht.restcontroller.util;

import org.apache.log4j.Logger;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * webservice 的 权限拦截器 暂时不使用,使用了AOP
 * @author  zzy
 * @Time 2018年6月8日13:58:32
 */
public class AuthorityRestFilter implements HandlerInterceptor {

    private SystemService systemService;
    /**
     * 包含匹配（请求链接包含该配置链接，就进行过滤处理）
     */
    public SystemService getSystemService() {
        return systemService;
    }
    @Autowired
    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }
    /**
     * 在controller后拦截
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
        System.out.println(1);
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
        System.out.println(2);
    }


    /**
     * 在controller前拦截
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        System.out.println(3);
        return true;
    }




    private void forward(HttpServletRequest request, HttpServletResponse response)  {
        //说明是不需要拦截的但又是 前端ajax 直接调用的。即是自定义的，但是考虑是否登录，这里先这是掉，以后考虑是否登录。
        //这里先给最高权限
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            System.out.println("获取输出流异常");
            e.printStackTrace();
        }
        out.println("successCallback({\"state\":\"权限不够！\"})");
        out.flush();
        out.close();
    }



}
