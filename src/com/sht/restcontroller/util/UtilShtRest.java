package com.sht.restcontroller.util;

import com.sht.restcontroller.tempentity.UserInfo;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.*;
import org.jeecgframework.web.system.service.SystemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UtilShtRest {


    /**
     * 根据 用户名 获取 用户
     * */
    public static UserInfo getUserInfoByUserName(SystemService systemService,String userName){
        TSUser user = new TSUser();
        List<TSUser> list = systemService.findHql(" from TSUser where userName='"+userName+"' ", new Object[]{});
        if(list!=null && list.size()>0){
            user = list.get(0);
        }
        return new UserInfo(user);
    }

    public static TSUser getTSUserByUserName(SystemService systemService,String userName){
        TSUser user = new TSUser();
        List<TSUser> list = systemService.findHql(" from TSUser where userName='"+userName+"' ", new Object[]{});
        if(list!=null && list.size()>0){
            user = list.get(0);
        }
        return user;
    }
    /**
     *  用户创建连接后在session中会有
     * @return
     */
    public static boolean isHavePower(HttpServletRequest request){
        //session.getSessionContext().getSession(sid);
        //TSUser user = ResourceUtil.getSessionUser();
        String sessionID = request.getParameter("SESSIONID");
        if(StringUtil.isEmpty(sessionID)){//没有获取到sessionID
            return  false;
        }
        HttpSession session = MySessionContext.getSession(sessionID);
        if(session==null){//sessionID 无效，过期了或者传的值不对
            return  false;
        }
        TSUser user = (TSUser) session.getAttribute("LOCAL_CLINET_USER");
        return  true;
    }

    /**
     *  根据ID获取 用户信息，有权限验证
     * @return
     */
    public static UserInfo getUserInfoByID(SystemService systemService, HttpServletRequest request){
        TSUser tsUser = new TSUser();
        String sessionID = request.getParameter("SESSIONID");
        String id = request.getParameter("id");
        if(StringUtil.isEmpty(sessionID)){//没有获取到sessionID 说明是获取的最高权限获取
            tsUser = systemService.getEntity(TSUser.class,id);
        }
        HttpSession session = MySessionContext.getSession(sessionID);
        if(session!=null){//sessionID  说明是 有权限限制的 获取当前登陆 用户信息
            tsUser = (TSUser) session.getAttribute("LOCAL_CLINET_USER");
        }
        UserInfo userInfo = new UserInfo(tsUser);
        return  userInfo;
    }


    /**
     *
     * @param systemService
     * @param req
     * @param user
     * @param roleid
     * @param orgId
     * @param isUpByName 是否根据用户名修改
     * @return
     */
    public static UserInfo   saveOrUpdateUser(SystemService systemService,HttpServletRequest req, TSUser user,String roleid,String orgId,boolean isUpByName){
        String message = null;
        UserInfo userInfo = null;
        // 得到用户的角色
        //String roleid = oConvertUtils.getString(req.getParameter("roleid"));
        String password = user.getPassword();
        String userid = user.getId();
        String username = user.getUserName();

        TSUser tempu = null;
        if(isUpByName){//想根据 用户名 修改
            if(StringUtil.isNotEmpty(username)){//想根据 已存在的 用户名字 //修改 用户
                List list = systemService.findHql(" from TSUser where userName='"+username+"'",new Object[]{});
                if(list!=null && list.size()>0){
                    tempu = (TSUser)list.get(0);
                }else{
                    return  userInfo;
                }
            }
        }


        if (StringUtil.isNotEmpty(userid) || (tempu!=null && tempu.getId()!=null) ) {//修改,根据用户名 或者账号ID修改
            TSUser users = new TSUser();

            if(StringUtil.isNotEmpty(userid)){
                users = systemService.getEntity(TSUser.class, user.getId());
            }else{//修改 用户 但是 传的 是 用户名字
                users =  tempu;
            }

            if(StringUtil.isNotEmpty(user.getEmail())){//修改 email
                users.setEmail(user.getEmail());
            }
            if(StringUtil.isNotEmpty(user.getOfficePhone())){//修改 OfficePhone
                users.setOfficePhone(user.getOfficePhone());
            }
            if(StringUtil.isNotEmpty(user.getMobilePhone())){
                users.setMobilePhone(user.getMobilePhone());
            }
            if(StringUtil.isNotEmpty(user.getDevFlag())){
                users.setDevFlag(user.getDevFlag());
            }
            if(StringUtil.isNotEmpty(user.getDept())){
                users.setDept(user.getDept());
            }
            if(StringUtil.isNotEmpty(user.getDuty())){
                users.setDuty(user.getDuty());
            }
            if(StringUtil.isNotEmpty(user.getBirth())){
                users.setBirth(user.getBirth());
            }
            if(StringUtil.isNotEmpty(user.getBirth())){
                users.setBirth(user.getBirth());
            }
            if(StringUtil.isNotEmpty(user.getWechat())){
                users.setWechat(user.getWechat());
            }
            if(StringUtil.isNotEmpty(user.getFacebook())){
                users.setFacebook(user.getFacebook());
            }
            if(StringUtil.isNotEmpty(user.getSelfResource())){
                users.setSelfResource(user.getSelfResource());
            }
            if(StringUtil.isNotEmpty(user.getNeedResource())){
                users.setNeedResource(user.getNeedResource());
            }
            if(StringUtil.isNotEmpty(user.getCompany())){
                users.setCompany(user.getCompany());
            }
            if(StringUtil.isNotEmpty(user.getBnTypeid())){
                users.setBnTypeid(user.getBnTypeid());
            }

            if(StringUtil.isNotEmpty(user.getCity())){
                users.setCity(user.getCity());
            }

            if(StringUtil.isNotEmpty(user.getComDesc())){
                users.setComDesc(user.getComDesc());
            }

            if(StringUtil.isNotEmpty(user.getLevel())){
                users.setLevel(user.getLevel());
            }


            //systemService.executeSql("delete from t_s_user_org where user_id=?", user.getId());
            //saveUserOrgList(req, user);
//            users.setTSDepart(user.getTSDepart());

            if(StringUtil.isNotEmpty(user.getRealName())){
                users.setRealName(user.getRealName());
            }

            if(StringUtil.isNotEmpty(user.getStatus())){
                users.setStatus(user.getStatus());
            }
            //users.setStatus(Globals.User_Normal);
            if(StringUtil.isNotEmpty(user.getActivitiSync())){
                users.setActivitiSync(user.getActivitiSync());
            }

            systemService.updateEntitie(users);
            List<TSRoleUser> ru = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
            systemService.deleteAllEntitie(ru);
            if (StringUtil.isNotEmpty(roleid)) {
                saveRoleUser(systemService,users, roleid);
            }
            userInfo = new UserInfo(users);
        } else {
            String userName = user.getUserName();
            List list = systemService.findHql(" from TSUser where userName='"+userName+"'",new Object[]{});
            if (list != null && list.size()>=1) {

            } else {
                user.setPassword(PasswordUtil.encrypt(user.getUserName(), password, PasswordUtil.getStaticSalt()));
//				if (user.getTSDepart().equals("")) {
//					user.setTSDepart(null);
//				}
                user.setStatus(Globals.User_Forbidden);//禁用用户
                user.setDeleteFlag(Globals.Delete_Normal);//正常标示用户
                user.setStatus((short)0);//锁定用户
                systemService.saveOrUpdate(user);

                saveUserOrg(systemService,user,orgId); // 固定不变，不用修改，默认为 一个 保存在 山海图 下

                if (StringUtil.isNotEmpty(roleid)) {
                    saveRoleUser(systemService,user, roleid);
                }
                userInfo = new UserInfo(user);

            }

        }
        return userInfo;
    }
    /**保存系统的用户 组织关系*/
    private static void  saveUserOrg(SystemService systemService, TSUser user,String orgId) {
        TSDepart depart = new TSDepart();
        depart.setId(orgId);
        TSUserOrg userOrg = new TSUserOrg();
        userOrg.setTsUser(user);
        userOrg.setTsDepart(depart);
        systemService.save(userOrg);

    }
    /**保存系统的用户和角色的关系*/
    protected static void saveRoleUser(SystemService systemService,TSUser user, String roleid) {
            TSRoleUser rUser = new TSRoleUser();
            TSRole role = systemService.getEntity(TSRole.class, roleid);
            rUser.setTSRole(role);
            rUser.setTSUser(user);
            systemService.save(rUser);
    }



}
