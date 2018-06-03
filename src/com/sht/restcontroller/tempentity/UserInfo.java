package com.sht.restcontroller.tempentity;

import org.jeecgframework.web.system.pojo.base.TSUser;

import java.text.SimpleDateFormat;

/**
 * Rest 使用的临时类
 * */
public class UserInfo {

    private String id;//id

    private String userName;//用户登陆名

    private String userKey;// 用户验证唯一标示

    private String password;//用户密码

    private String realName;//用户名

    private String birth;//生日

    private String dept;//部门

    private String duty;//职位

    private String mobilePhone;// 手机

    private String officePhone;// 办公电话

    private String wechat;//微信

    private String facebook;//facebook

    private String selfResource;//我的资源 self_resource

    private String needResource;//需要的资源  need_resource

    private String company;//公司  company

    private String bnTypeid;//业务类型  bn_type_id

    private String city;//所在城市  city

    private String comDesc;//公司描述  com_desc

    private String status;//用户级别  status  1：在线,2：离线,0：禁用 3：手机 4：PC 5：其他

    private String level;//用户级别  level

    private String createDate;/**创建时间*/

    public UserInfo(){

    }
    /**反向赋值的 构造器 */
    public UserInfo(TSUser tsUser){
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.id = tsUser.getId();
        this.userName = tsUser.getUserName();
        this.userKey = tsUser.getUserKey();
        this.password = tsUser.getPassword();
        this.realName = tsUser.getRealName();
        if(tsUser.getBirth()!=null){
            this.birth = sdf1.format(tsUser.getBirth()) ;
        }
        this.duty = tsUser.getDuty();
        this.mobilePhone = tsUser.getMobilePhone();
        this.officePhone = tsUser.getOfficePhone();
        this.wechat = tsUser.getWechat();
        this.facebook = tsUser.getFacebook();
        this.selfResource = tsUser.getSelfResource();
        this.needResource = tsUser.getNeedResource();
        this.company = tsUser.getCompany();
        this.bnTypeid = tsUser.getBnTypeid();
        this.city = tsUser.getCity();
        this.comDesc = tsUser.getComDesc();
        this.status = tsUser.getStatus()+"";
        if(tsUser.getCreateDate()!=null){
            this.createDate = sdf2.format(tsUser.getCreateDate()) ;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSelfResource() {
        return selfResource;
    }

    public void setSelfResource(String selfResource) {
        this.selfResource = selfResource;
    }

    public String getNeedResource() {
        return needResource;
    }

    public void setNeedResource(String needResource) {
        this.needResource = needResource;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBnTypeid() {
        return bnTypeid;
    }

    public void setBnTypeid(String bnTypeid) {
        this.bnTypeid = bnTypeid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComDesc() {
        return comDesc;
    }

    public void setComDesc(String comDesc) {
        this.comDesc = comDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
