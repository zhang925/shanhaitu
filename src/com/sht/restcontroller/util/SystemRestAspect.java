package com.sht.restcontroller.util;


import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @Description webservice 权限验证的 拦截
 * @author fengjk
 * @date 2017-5-2 下午3:24:37
 */
@Aspect
@Component
public class SystemRestAspect{
    // 注入Service用于把日志保存数据库

    // <aop:aspectj-autoproxy proxy-target-class="true"/> 注意 SpringMVC 需要开启这个

    private static final Logger logger = LoggerFactory.getLogger(SystemRestAspect.class);

    @Autowired
    private HttpServletRequest request;

    private Date beforeDate;
    private Date afterDate;

    private String state;//保留字段
    @Pointcut("@annotation(com.sht.restcontroller.util.RestAuthority)")
    public void beforeLog() {//只 拦截 带注解的 @RestAuthority 的方法

    }
    @Pointcut("@annotation(com.sht.restcontroller.util.RestAuthority)")
    public void controllerAspect(){//只 拦截 带注解的 @RestAuthority 的方法

    }

    /**
     *
     * @Description 前置 拦截
     * @author zzy
     * @date 2017-5-23 下午6:22:07
     */

    @Before(value = "beforeLog()")//@Pointcut(value="切入点表达式", argNames = "参数名列表")
    public void beforePointCut(){//切入前。
        //判断用户是否 带 token

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


    }

    /**
     *
     * @Description 后置通知，记录用户在Controller操作记录
     * @author fengjk
     * @date 2017-4-26 上午11:26:59
     */
    @AfterReturning(pointcut = "controllerAspect()", returning = "res")
    public void afterPointCut(JoinPoint joinPoint, Object res) {//切入后

        try {

            Class[] parameterTypes = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
            Method method = null;
            String methodName = joinPoint.getSignature().getName();
            Class targetClass = joinPoint.getTarget().getClass();
            method = targetClass.getMethod(methodName,parameterTypes);
            boolean hasAnnotation = method.isAnnotationPresent(RestAuthority.class);
            if(hasAnnotation){

                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                //InetAddress inetAddress = InetAddress.getLocalHost();
                //String ip = inetAddress.getHostAddress();
                // 读取session中的用户
                HttpSession session = request.getSession();
                //String loginName = (String) session.getAttribute("loginName");
                //Long userId = (Long) session.getAttribute("userId");

                String operationName = method.getAnnotation(RestAuthority.class).name();
                //JSONObject paramObject = new JSONObject();
                //paramObject.put("account", loginName);
                //paramObject.put("userId", userId);
                //paramObject.put("ipAddress", ip);
                //paramObject.put("description", operationName);
                //paramObject.put("time", new Date());
               // paramObject.put("method", (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
                // 前台执行操作传入参数
                ///paramObject.put("remark", Arrays.toString(joinPoint.getArgs()));


                // -------------------执行 拦截 操作----------------------------




            }

        } catch (Exception e) {
            // 记录本地异常日志
            logger.warn("日志记录异常信息：", e);
        }
    }



}