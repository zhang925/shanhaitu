package com.zzy.entity.snotice;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 测试公告
 * @author zhangdaihao
 * @date 2018-05-22 16:49:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sti_notice", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SnoticeEntity implements java.io.Serializable {
	/**ID*/
	private java.lang.String id;
	/**标题*/
	private java.lang.String title;
	/**内容*/
	private java.lang.String content;
	/**通知公告类型（0：通知，1:公告）*/
	private java.lang.String type;
	/**公开范围（0:所有人（包括未注册人员），1：系统已注册人员，2：单位管理员3：专家）*/
	private java.lang.String level;
	/**链接地址*/
	private java.lang.String linkurl;
	/**公告通知的有效日期*/
	private java.lang.String expirydate;
	/**创建者ID*/
	private java.lang.String createuserid;
	/**创建者名字*/
	private java.lang.String createusername;
	/**创建时间*/
	private java.lang.String createtime;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ID
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ID
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=255)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=6000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通知公告类型（0：通知，1:公告）
	 */
	@Column(name ="TYPE",nullable=true,length=2)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通知公告类型（0：通知，1:公告）
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公开范围（0:所有人（包括未注册人员），1：系统已注册人员，2：单位管理员3：专家）
	 */
	@Column(name ="LEVEL",nullable=true,length=2)
	public java.lang.String getLevel(){
		return this.level;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公开范围（0:所有人（包括未注册人员），1：系统已注册人员，2：单位管理员3：专家）
	 */
	public void setLevel(java.lang.String level){
		this.level = level;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  链接地址
	 */
	@Column(name ="LINKURL",nullable=true,length=500)
	public java.lang.String getLinkurl(){
		return this.linkurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  链接地址
	 */
	public void setLinkurl(java.lang.String linkurl){
		this.linkurl = linkurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公告通知的有效日期
	 */
	@Column(name ="EXPIRYDATE",nullable=true,length=32)
	public java.lang.String getExpirydate(){
		return this.expirydate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公告通知的有效日期
	 */
	public void setExpirydate(java.lang.String expirydate){
		this.expirydate = expirydate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建者ID
	 */
	@Column(name ="CREATEUSERID",nullable=true,length=32)
	public java.lang.String getCreateuserid(){
		return this.createuserid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建者ID
	 */
	public void setCreateuserid(java.lang.String createuserid){
		this.createuserid = createuserid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建者名字
	 */
	@Column(name ="CREATEUSERNAME",nullable=true,length=200)
	public java.lang.String getCreateusername(){
		return this.createusername;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建者名字
	 */
	public void setCreateusername(java.lang.String createusername){
		this.createusername = createusername;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建时间
	 */
	@Column(name ="CREATETIME",nullable=true,length=32)
	public java.lang.String getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建时间
	 */
	public void setCreatetime(java.lang.String createtime){
		this.createtime = createtime;
	}
}
