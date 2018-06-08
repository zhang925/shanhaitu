package com.jeecg;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.kisso.SSOConfig;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.SSOToken;
import com.sht.restcontroller.util.MySessionContext;
import com.sht.restcontroller.util.UtilSht;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 本拦截器只对webservice 有效 即 wwww.aaa.com/api/**的访问拦截
 */
public class CORSFilter implements Filter {
    @Autowired
    private  SystemService systemService;
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE, PUT");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");

       if(isAuthorization(response)){
            chain.doFilter(req, resp);
        }else{
            response.setCharacterEncoding("utf8");
           JSONObject obj = new JSONObject();
           obj.put("responsecode","403");
           obj.put("msg", "没有权限，或者登录过时，请检查账户信息。");
            response.getWriter().println(obj.toJSONString());
        }




    }

    public void init(FilterConfig config) throws ServletException {

    }


    /**
     * 在前端的时候有时候不需要登陆就要拿到一些数据
     *  true 表示不需要拦截，false 需要拦截
     * @return
     */
    public boolean isHandle(HttpServletRequest request){
        String requestUrl = request.getRequestURI();//获取当前请求的url
        //requestUrl = requestUrl.replace("/","");
        //系统免过滤的白名单，在单点登录的sso.properties的white.list配置
        String whiteList = UtilSht.getPripertyPath("sso.properties",null,"white.list");
        boolean flag = false;
        if(whiteList!=null && !"".equals(whiteList)){
           if( whiteList.indexOf(requestUrl)!=-1){//找到该地址
               flag = true;
           }
        }
        return flag;//不需要拦截
    }



    public boolean isAuthorization( HttpServletResponse response){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(isHandle( request)){//是白名单
            return true;
        }
        String authorization = request.getHeader("Authorization");//token
        //"SESSIONID=947CDE0762299E1241430790C588A7F3; aaa=aaa"
        String SESSIONID  = "";
        if (authorization != null && !"".equals(authorization)) { // cookie 里面是不允许 ; 存在的，所以这里可以放心截取
            String cookies[] = authorization.split(";");
            for (String cookie : cookies){
                String cooki[] = cookie.split("=");
                if(cooki!=null && cooki.length>1){//说明是正常的cookie
                    if(cooki[0].trim().equals("SESSIONID")){
                        SESSIONID = cooki[1];
                    }
                }
            }
        }
        if("".equals(SESSIONID)){
            return false;
        }
        MySessionContext mySessionContext = MySessionContext.getSingleInstance();
        HttpSession session = mySessionContext.getSession(SESSIONID);
        if(session!=null){//说明sesssion没有注销
            return true;
        }
        return false;
    }
}
