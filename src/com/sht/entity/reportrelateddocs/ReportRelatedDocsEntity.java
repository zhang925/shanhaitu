package com.sht.entity.reportrelateddocs;

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
 * @Description: 调研报告相关资料
 * @author zhangdaihao
 * @date 2018-06-13 17:02:15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_report_related_docs", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ReportRelatedDocsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**调研报告ID*/
	private java.lang.String investReportId;
	/**资料title*/
	private java.lang.String title;
	/**文件格式*/
	private java.lang.String format;
	/**资源路径*/
	private java.lang.String url;
	/**状态*/
	private java.lang.Integer status;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)

	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  调研报告ID
	 */
	@Column(name ="INVEST_REPORT_ID",nullable=true,precision=10,scale=0)
	public java.lang.String getInvestReportId(){
		return this.investReportId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  调研报告ID
	 */
	public void setInvestReportId(java.lang.String investReportId){
		this.investReportId = investReportId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资料title
	 */
	@Column(name ="TITLE",nullable=true,length=800)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资料title
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件格式
	 */
	@Column(name ="FORMAT",nullable=true,length=64)
	public java.lang.String getFormat(){
		return this.format;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件格式
	 */
	public void setFormat(java.lang.String format){
		this.format = format;
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
