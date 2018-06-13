package com.sht.entity.reportrelatedimages;

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
 * @Description: 调研报告相关图集
 * @author zhangdaihao
 * @date 2018-06-13 17:02:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_report_related_images", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ReportRelatedImagesEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**调研报告ID*/
	private java.lang.String investReportId;
	/**图片描述*/
	private java.lang.String summary;
	/**资源路径*/
	private java.lang.String url;
	/**状态*/
	private java.lang.Integer status;
	
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
	 *@return: java.lang.String  调研报告ID
	 */
	@Column(name ="INVEST_REPORT_ID",nullable=true,length=32)
	public java.lang.String getInvestReportId(){
		return this.investReportId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  调研报告ID
	 */
	public void setInvestReportId(java.lang.String investReportId){
		this.investReportId = investReportId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片描述
	 */
	@Column(name ="SUMMARY",nullable=true,length=800)
	public java.lang.String getSummary(){
		return this.summary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片描述
	 */
	public void setSummary(java.lang.String summary){
		this.summary = summary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资源路径
	 */
	@Column(name ="URL",nullable=true,length=1000)
	public java.lang.String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资源路径
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="STATUS",nullable=true,precision=10,scale=0)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
}
