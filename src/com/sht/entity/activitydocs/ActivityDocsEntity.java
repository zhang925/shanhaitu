package com.sht.entity.activitydocs;

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
 * @Description: 活动资料
 * @author zhangdaihao
 * @date 2018-06-15 11:06:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_activity_docs", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ActivityDocsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**活动ID*/
	private java.lang.String activityId;
	/**资料路径*/
	private java.lang.String docUrl;
	/**名字*/
	private java.lang.String docName;
	/**分享嘉宾*/
	private java.lang.String shareBy;
	/**公司*/
	private java.lang.String company;
	
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
	 *@return: java.lang.String  活动ID
	 */
	@Column(name ="ACTIVITY_ID",nullable=true,length=32)
	public java.lang.String getActivityId(){
		return this.activityId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动ID
	 */
	public void setActivityId(java.lang.String activityId){
		this.activityId = activityId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资料路径
	 */
	@Column(name ="DOC_URL",nullable=true,length=1000)
	public java.lang.String getDocUrl(){
		return this.docUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资料路径
	 */
	public void setDocUrl(java.lang.String docUrl){
		this.docUrl = docUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名字
	 */
	@Column(name ="DOC_NAME",nullable=true,length=255)
	public java.lang.String getDocName(){
		return this.docName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名字
	 */
	public void setDocName(java.lang.String docName){
		this.docName = docName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分享嘉宾
	 */
	@Column(name ="SHARE_BY",nullable=true,length=1000)
	public java.lang.String getShareBy(){
		return this.shareBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分享嘉宾
	 */
	public void setShareBy(java.lang.String shareBy){
		this.shareBy = shareBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司
	 */
	@Column(name ="COMPANY",nullable=true,length=512)
	public java.lang.String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司
	 */
	public void setCompany(java.lang.String company){
		this.company = company;
	}
}
