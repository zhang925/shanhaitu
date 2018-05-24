package com.zzy.entity.classic;

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
 * @Description: 经典语录
 * @author zhangdaihao
 * @date 2017-09-19 10:05:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "A_Z_CLASSIC", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ClassicEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**uid*/
	private java.lang.String uid;
	/**title*/
	private java.lang.String title;
	/**content*/
	private java.lang.String content;
	/**createtime*/
	private java.lang.String createtime;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  uid
	 */
	@Column(name ="UID",nullable=true,length=255)
	public java.lang.String getUid(){
		return this.uid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  uid
	 */
	public void setUid(java.lang.String uid){
		this.uid = uid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  title
	 */
	@Column(name ="TITLE",nullable=true,length=255)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  title
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  content
	 */
	@Column(name ="CONTENT",nullable=true,length=255)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  content
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  createtime
	 */
	@Column(name ="CREATETIME",nullable=true,length=255)
	public java.lang.String getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  createtime
	 */
	public void setCreatetime(java.lang.String createtime){
		this.createtime = createtime;
	}
}
