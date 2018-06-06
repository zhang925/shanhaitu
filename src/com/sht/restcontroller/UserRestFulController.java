package com.sht.restcontroller;

import com.alibaba.fastjson.JSONObject;
import com.sht.restcontroller.tempentity.AjaxMsg;
import com.sht.restcontroller.tempentity.UserInfo;
import com.sht.restcontroller.util.MySessionContext;
import com.sht.restcontroller.util.UtilEmail;
import com.sht.restcontroller.util.UtilSht;
import com.sht.restcontroller.util.UtilShtRest;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.controller.core.LoginController;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.MutiLangServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserRestFulController {
    @Autowired
    private UserService userService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private MutiLangServiceI mutiLangService;

    /**
     * 用户登陆
     * @param username
     * @param password
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg login(String username,String password,HttpServletResponse response,HttpServletRequest request){//登陆

      AjaxMsg ajaxMsg = new AjaxMsg();
      TSUser tsUser = new TSUser();//登陆后系统中 获取一个 session 的用户信息
        tsUser.setUserName(username);
        tsUser.setPassword(password);
      if(StringUtils.isEmpty(username)){
          ajaxMsg.setMsg("用户名不能为空！");
          return ajaxMsg;
      }
        if(StringUtils.isEmpty(password)){
            ajaxMsg.setMsg( "密码不能为空！");
            return ajaxMsg;
        }
      TSUser u = userService.checkUserExits(tsUser);
      if(u==null){
          ajaxMsg.setMsg( "用户名或者密码错误！");
          return ajaxMsg;
      }





        //登陆 系统
        LoginController lc = new LoginController();
        lc.saveLoginSuccessInfoRest(systemService,mutiLangService,request,response,  u);//登陆系统 日志

        UserInfo userInfo = new UserInfo(u);//最终要返回给页面的 用户信息
        //ajaxMsg.setMsg(request.getSession().getId()); //这个session ID 客户端 要 放到浏览器 cookie 里面 并且 名字必须为 SESSIONID

        JSONObject obj = new JSONObject();
        obj.put("SESSIONID", request.getSession().getId());
        obj.put("result", userInfo);
        ajaxMsg.setMsg("success");

        ajaxMsg.setModel(obj);
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

    /**
     *  根据ID获取当前 在线 用户的实体 需要 SESSIONID 参数，必须是大写
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/userInfo",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg userInfo( HttpServletResponse response, HttpServletRequest request){
        //Cookie[] cookies = request.getCookies();
        //String cookie = request.getParameter("cookie");
        AjaxMsg ajaxMsg = new AjaxMsg();
        String msg = "success";
        Object responseCode = HttpStatus.OK.value();
        UserInfo userInfo = null;
        if(UtilShtRest.isHavePower( request)){//session 有效 session 有效期 判断暂时略过
            userInfo = UtilShtRest.getUserInfoByID(systemService,request);
        }else{
            ajaxMsg.setMsg("登陆超时");
            ajaxMsg.setResponsecode(HttpStatus.REQUEST_TIMEOUT.value());
            return ajaxMsg;
        }
        ajaxMsg.setMsg(msg);
        ajaxMsg.setModel(userInfo);
        ajaxMsg.setResponsecode(responseCode);
        return ajaxMsg;
    }


    /**
     *  根据ID获取 用户的实体
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMsg userInfo(@PathVariable String id ){
        AjaxMsg ajaxMsg = new AjaxMsg();
        String msg = "success";
        Object responseCode = HttpStatus.OK.value();
        if(StringUtil.isEmpty(id)){
            ajaxMsg.setMsg("id不能为空");
            ajaxMsg.setResponsecode(responseCode);
            return ajaxMsg;
        }
        TSUser tsUser = systemService.getEntity(TSUser.class,id);
        UserInfo userInfo = new UserInfo(tsUser);
        ajaxMsg.setMsg(msg);
        ajaxMsg.setModel(userInfo);
        ajaxMsg.setResponsecode(responseCode);
        return ajaxMsg;
    }

    /**
     * 根据用户名字 获取 用户实体
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/userInfoByName",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg userInfoByName(String userName, HttpServletResponse response, HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        String msg = "success";
        Object responseCode = HttpStatus.OK.value();
        UserInfo userInfo = null;
        if(StringUtil.isEmpty(userName)){
            ajaxMsg.setMsg("用户名不能为空！");
            ajaxMsg.setResponsecode(responseCode);
            return ajaxMsg;
        }
        userInfo = UtilShtRest.getUserInfoByUserName(systemService,userName);
        ajaxMsg.setMsg(msg);
        ajaxMsg.setModel(userInfo);
        ajaxMsg.setResponsecode(responseCode);
        return ajaxMsg;
    }

    /**注册*/
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg regist(TSUser tsUser , HttpServletResponse response, HttpServletRequest request){//注册
        AjaxMsg ajaxMsg = new AjaxMsg();
        String msg = "success";
        UserInfo userInfo = null;
        if(tsUser!=null){
            tsUser.setDevFlag("0");//普通用户，没有后台权限
            String roleid = "8a8ab0b246dc81120146dc81818b0051";//普通用户 角色
            String orgId = "402880f063be7e990163be85abfb0003";//默认到 山海图下 系统部门为 setDepartid 外部的 是duty 是具体名字职位 有点混淆
             userInfo = UtilShtRest.saveOrUpdateUser( systemService, request,  tsUser, roleid, orgId,false);
            if(userInfo==null){
                msg = "注册失败，该用户名已经存在！";
            }
        }
        ajaxMsg.setModel(userInfo);
        ajaxMsg.setResponsecode( HttpStatus.OK.value());
        ajaxMsg.setMsg(msg);
        return ajaxMsg;
    }


    /**修改*/
    @RequestMapping(value = "/uptuser",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsg uptuser(TSUser tsUser , HttpServletResponse response, HttpServletRequest request){//注册
        AjaxMsg ajaxMsg = new AjaxMsg();
        String msg = "success";
        if(StringUtil.isEmpty(tsUser.getUserName())){//用户名字
            ajaxMsg.setResponsecode( HttpStatus.OK.value());
            ajaxMsg.setMsg("用户名字，不能为空！");
            return ajaxMsg;
        }
        UserInfo userInfo = UtilShtRest.saveOrUpdateUser( systemService, request,  tsUser, "", "",true);
        if(userInfo==null || userInfo.getId()==null){
            msg = "该用户不存在!";
        }else{
            ajaxMsg.setModel(userInfo);
        }
        ajaxMsg.setResponsecode( HttpStatus.OK.value());
        ajaxMsg.setMsg(msg);
        return ajaxMsg;
    }

    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)//验证 邮箱
    @ResponseBody
    public AjaxMsg sendEmail(TSUser tsUser , HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        String email = tsUser.getEmail();
        String msg = "success";
        if(StringUtil.isEmpty(email)){//
            msg = "收件人邮箱不能为空。";
        }
        //该用户 已经注册了，只是来验证一下邮箱，解锁。
        //这里的用户名字就是，邮箱
        String userName = tsUser.getUserName();//用户传过来的 邮箱
        if(StringUtil.isEmpty(userName)){//没有传递 用户名
            if(StringUtil.isEmpty(tsUser.getEmail())){//没有传递 邮箱,
                ajaxMsg.setResponsecode(HttpStatus.OK.value());
                ajaxMsg.setMsg("邮箱不能为空。");
                return ajaxMsg;
            }else{
                userName = tsUser.getEmail();//用邮箱 来查询
            }
        }
        if(StringUtil.isEmpty(userName)){
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            ajaxMsg.setMsg("用户名字和邮箱不能同时为空。");
            return ajaxMsg;
        }
        //获取已经锁定的用户
        UserInfo userInfo = UtilShtRest.getUserInfoByUserName(systemService,userName);
        if(userInfo==null || userInfo.getId()==null){
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            ajaxMsg.setMsg("当前邮箱还未与本平台绑定。");
            return ajaxMsg;
        }
        //锁定 用户 已经存在
        Integer radomCode = (int)((Math.random()*9+1)*100000);
        UtilEmail.sendEmailForSht(tsUser.getEmail(),radomCode);
        request.getSession().setAttribute("CHECKCODE",radomCode);

        //ajaxMsg.setMsg(request.getSession().getId().toString());//这个session ID 客户端 要 放到浏览器 cookie 里面 并且 名字必须为 CODESESSIONID


        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        JSONObject obj = new JSONObject();
        obj.put("CHECKSESSIONID", request.getSession().getId());
        ajaxMsg.setMsg("success");
        ajaxMsg.setModel(obj);

        return ajaxMsg;
    }



    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST) // 用户 验证 邮箱 注册
    @ResponseBody
    public AjaxMsg checkEmail(TSUser tsUser ,String code,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        //前端 cookie 春一个 EMAILSESSIONID 验证的时候 传过来
        String codeSessionID = request.getParameter("CHECKSESSIONID");//后去浏览器 的 codesessionid 的 cookie
        String msg = "success";
        UserInfo userInfo = null;
        if(StringUtil.isEmpty(codeSessionID)){//没有获取到
            msg = "验证码已经失效！";
            ajaxMsg.setResponsecode(HttpStatus.REQUEST_TIMEOUT.value());
        }else {
            HttpSession session = MySessionContext.getSession(codeSessionID);//获取 code的session
            if(session!=null){
                Object CHECKEMAILCODE = session.getAttribute("CHECKCODE");
                if(StringUtil.isEmpty(code)){//用户没有传过来验证码。
                    msg = "验证码不能为空！";
                }else if(code.equals(CHECKEMAILCODE.toString())){//验证通过
                    //用户 解锁
                    String userName = tsUser.getUserName();
                    if(userName==null){//没有传值
                        if(StringUtil.isEmpty(tsUser.getEmail())){//没有传递 邮箱,
                            ajaxMsg.setResponsecode(HttpStatus.OK.value());
                            ajaxMsg.setMsg("用户名不能为空。");
                            return ajaxMsg;
                        }else{
                            userName = tsUser.getEmail();//用邮箱 来查询
                        }
                    }
                    if(StringUtil.isEmpty(userName)){
                        ajaxMsg.setResponsecode(HttpStatus.OK.value());
                        ajaxMsg.setMsg("用户名字和邮箱不能同时为空。");
                        return ajaxMsg;
                    }
                    TSUser tsUser1 =   UtilShtRest.getTSUserByUserName(systemService,userName);
                    if(tsUser1!=null && tsUser1.getId()!=null){
                        tsUser1.setStatus((short)1);//激活在线
                        userInfo = UtilShtRest.saveOrUpdateUser( systemService, request,  tsUser1, "", "",false);
                        ajaxMsg.setModel(userInfo);
                    }else{
                        ajaxMsg.setMsg("系统中没有查到用户为："+userName +" 的用户。");
                        ajaxMsg.setResponsecode(HttpStatus.OK.value());
                        return ajaxMsg;
                    }

                }else{
                    msg = "验证码已经失效！";
                }
            }else{
                msg = "验证码已经失效！";
            }

        }
        ajaxMsg.setMsg(msg);
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

    /**找回密码*/
    @RequestMapping(value = "/sendEmailRe",method = RequestMethod.POST)//验证 邮箱
    @ResponseBody
    public AjaxMsg sendEmailRe(TSUser tsUser , HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        String email = tsUser.getEmail();
        String msg = "success";
        if(StringUtil.isEmpty(email)){//
            msg = "邮箱不能为空。";
        }
        Integer radomCode = (int)((Math.random()*9+1)*100000);
        UtilEmail.sendEmailForSht(tsUser.getEmail(),radomCode);

        request.getSession().setAttribute("CHECKRECODE",radomCode);

        //ajaxMsg.setMsg(request.getSession().getId().toString());//这个session ID 客户端 要 放到浏览器 cookie 里面 并且 名字必须为 CODESESSIONID
        JSONObject obj = new JSONObject();
        obj.put("CHECKRESESSION", request.getSession().getId());
        ajaxMsg.setMsg("success");
        ajaxMsg.setModel(obj);
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }


    /**验证 找回 密码 的 验证码*/
    @RequestMapping(value = "/ckEmailForRe",method = RequestMethod.POST) // 用户 验证 邮箱 注册
    @ResponseBody
    public AjaxMsg ckEmailForRe(TSUser tsUser ,String code,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        //前端 cookie 春一个 RESESSIONID 验证的时候 传过来
        String codeSessionID = request.getParameter("CHECKRESESSION");//后去浏览器 的 codesessionid 的 cookie RESESSIONID
        String msg = "success";
        UserInfo userInfo = null;
        if(StringUtil.isEmpty(codeSessionID)){//没有获取到
            msg = "验证码已经失效！";
            ajaxMsg.setResponsecode(HttpStatus.REQUEST_TIMEOUT.value());
        }else {
            HttpSession session = MySessionContext.getSession(codeSessionID);//获取 code的session
            if(session!=null){
                //从上一个session 中读取 code
                Object CHECKEMAILFORGET = session.getAttribute("CHECKRECODE");
                if(StringUtil.isEmpty(code)){//用户没有传过来验证码。
                    msg = "验证码不能为空！";
                }else if(code.equals(CHECKEMAILFORGET.toString())){//验证通过
                    //根据 邮箱为账户的 修改账户 密码
                    msg = "success";
                }else{
                    msg = "验证码已经失效！";
                }
            }else{
                msg = "验证码已经失效！";
            }

        }
        ajaxMsg.setMsg(msg);
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }


    @RequestMapping(value = "/reSetPassWord",method = RequestMethod.POST) // 用户 验证 邮箱 注册
    @ResponseBody
    public AjaxMsg reSetPassWord(TSUser tsUser ,String code,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        //修改密码
        String password = oConvertUtils.getString(request.getParameter("password"));
        String temp = "";
        String userName = tsUser.getUserName();
        if(userName==null){
            temp  = tsUser.getEmail();
        }else {
            temp = userName;
        }
        String newPassword = PasswordUtil.encrypt(temp, password, PasswordUtil.getStaticSalt());

        List list = systemService.findHql(" from TSUser where userName='"+userName+"'",new Object[]{});

        TSUser tsUser1 = (TSUser)list.get(0);
        tsUser1.setPassword(newPassword);
        systemService.updateEntitie(tsUser1);
        ajaxMsg.setMsg("密码已经重置，请牢记密码: "+password);
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }

    @RequestMapping(value = "/reSetPassWordOnLine",method = RequestMethod.POST) // 用户 验证 邮箱 注册
    @ResponseBody
    public AjaxMsg reSetPassWordOnLine(TSUser tsUser ,String code,HttpServletResponse response,HttpServletRequest request){
        AjaxMsg ajaxMsg = new AjaxMsg();
        //修改密码
        String password = oConvertUtils.getString(request.getParameter("password"));
        String newpassword = oConvertUtils.getString(request.getParameter("newpassword"));
        if(StringUtil.isEmpty(password)){
            ajaxMsg.setMsg("密码不能为空!");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }

        if(StringUtil.isEmpty(newpassword)){
            ajaxMsg.setMsg("新密码不能为空!");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }
        String temp = "";
        String userName = tsUser.getUserName();
        if(userName==null){
            temp  = tsUser.getEmail();
        }else {
            temp = userName;
        }
        String passwordP = PasswordUtil.encrypt(temp, password, PasswordUtil.getStaticSalt());

        List list = systemService.findHql(" from TSUser where userName='"+userName+"' and password='"+passwordP+"' ",new Object[]{});
        TSUser tsUser1 = null;
        if(list!=null && list.size()>0){
             tsUser1 = (TSUser)list.get(0);
        }

        if(tsUser1==null){
            ajaxMsg.setMsg("密码不正确!");
            ajaxMsg.setResponsecode(HttpStatus.OK.value());
            return ajaxMsg;
        }


        String newPasswordP = PasswordUtil.encrypt(temp, newpassword, PasswordUtil.getStaticSalt());
        tsUser1.setPassword(newPasswordP);
        systemService.updateEntitie(tsUser1);
        ajaxMsg.setMsg("密码已经重置，请牢记密码: "+newpassword);
        ajaxMsg.setResponsecode(HttpStatus.OK.value());
        return ajaxMsg;
    }
}

