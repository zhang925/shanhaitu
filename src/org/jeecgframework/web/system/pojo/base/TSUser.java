package org.jeecgframework.web.system.pojo.base;

import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 系统用户表
 *  @author  张代浩
 */
@Entity
@Table(name = "t_s_user")
@PrimaryKeyJoinColumn(name = "id")
public class TSUser extends TSBaseUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String signatureFile;// 签名文件

	@Excel(name = "手机" ,width = 20)
	private String mobilePhone;// 手机
	@Excel(name = "办公电话",width = 20)
	private String officePhone;// 办公电话
	@Excel(name = "邮箱",width = 25)
	private String email;// 邮箱

	@Excel(name = "部门",width = 25)
	private String dept;//部门

	@Excel(name = "职位",width = 25)
	private String duty;//职位



	@Excel(name = "生日",width = 25)
	private java.util.Date birth;//生日

	@Excel(name = "微信",width = 25)
	private String wechat;//微信

	@Excel(name = "facebook",width = 25)
	private String facebook;//facebook

	@Excel(name = "我的资源",width = 25)
	private String selfResource;//我的资源 self_resource

	@Excel(name = "需要的资源",width = 25)
	private String needResource;//需要的资源  need_resource

	@Excel(name = "公司",width = 25)
	private String company;//公司  company

	@Excel(name = "业务类型ID",width = 25)
	private String bnTypeid;//公司  bn_type_id

	@Excel(name = "所在城市",width = 25)
	private String city;//所在城市  city

	@Excel(name = "公司描述",width = 25)
	private String comDesc;//公司描述  com_desc

	@Excel(name = "用户级别",width = 25)
	private String level;//用户级别  level


	/**创建时间*/
	private java.util.Date createDate;
	/**创建人ID*/
	private java.lang.String createBy;
	/**创建人名称*/
	private java.lang.String createName;
	/**修改时间*/
	private java.util.Date updateDate;
	/**修改人*/
	private java.lang.String updateBy;
	/**修改人名称*/
	private java.lang.String updateName;
	/**头像*/
	private java.lang.String portrait;
	/**开发权限标志*/
	private java.lang.String devFlag;

	@Column(name = "dev_flag", length = 2)
	public String getDevFlag() {
		return devFlag;
	}

	public void setDevFlag(String devFlag) {
		this.devFlag = devFlag;
	}
	@Column(name = "signatureFile", length = 100)
	public String getSignatureFile() {
		return this.signatureFile;
	}

	public void setSignatureFile(String signatureFile) {
		this.signatureFile = signatureFile;
	}

	@Column(name = "mobilePhone", length = 30)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "officePhone", length = 20)
	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="create_date",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */
	@Column(name ="create_by",nullable=true,length=32)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="create_name",nullable=true,length=32)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="update_date",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人ID
	 */
	@Column(name ="update_by",nullable=true,length=32)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人ID
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人名称
	 */
	@Column(name ="update_name",nullable=true,length=32)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	@Column(name = "portrait", length = 100)
	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}


	@Column(name ="wechat",nullable=true,length=200)
	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	@Column(name ="facebook",nullable=true,length=200)
	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	@Column(name ="self_resource",nullable=true,length=50000)
	public String getSelfResource() {
		return selfResource;
	}

	public void setSelfResource(String selfResource) {
		this.selfResource = selfResource;
	}
	@Column(name ="need_resource",nullable=true,length=50000)
	public String getNeedResource() {
		return needResource;
	}

	public void setNeedResource(String needResource) {
		this.needResource = needResource;
	}
	@Column(name ="company",nullable=true,length=256)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name ="bn_type_id",nullable=true,length=32)
	public String getBnTypeid() {
		return bnTypeid;
	}

	public void setBnTypeid(String bnTypeid) {
		this.bnTypeid = bnTypeid;
	}
	@Column(name ="city",nullable=true,length=256)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name ="com_desc",nullable=true,length=5000)
	public String getComDesc() {
		return comDesc;
	}

	public void setComDesc(String comDesc) {
		this.comDesc = comDesc;
	}
	@Column(name ="level",nullable=true,length=5000)
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name ="dept",nullable=true,length=256)
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}


	@Column(name ="birth",nullable=true,length=50)
	public java.util.Date getBirth() {
		return birth;
	}

	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}

	@Column(name ="duty",nullable=true,length=50)
	public String getDuty() {
		return duty;
	}


	public void setDuty(String duty) {
		this.duty = duty;
	}


}