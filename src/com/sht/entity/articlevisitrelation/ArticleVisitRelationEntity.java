package com.sht.entity.articlevisitrelation;

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
 * @Description: 文章访问渠道
 * @author zhangdaihao
 * @date 2018-05-29 21:55:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_article_visit_relation", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ArticleVisitRelationEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**文章ID*/
	private java.lang.String articleId;
	/**访问渠道*/
	private java.lang.String visitChannel;
	/**访问时间*/
	private java.util.Date visitTime;
	
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
	 *@return: java.lang.String  文章ID
	 */
	@Column(name ="ARTICLE_ID",nullable=true,length=32)
	public java.lang.String getArticleId(){
		return this.articleId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章ID
	 */
	public void setArticleId(java.lang.String articleId){
		this.articleId = articleId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  访问渠道
	 */
	@Column(name ="VISIT_CHANNEL",nullable=true,length=32)
	public java.lang.String getVisitChannel(){
		return this.visitChannel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  访问渠道
	 */
	public void setVisitChannel(java.lang.String visitChannel){
		this.visitChannel = visitChannel;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  访问时间
	 */
	@Column(name ="VISIT_TIME",nullable=true)
	public java.util.Date getVisitTime(){
		return this.visitTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  访问时间
	 */
	public void setVisitTime(java.util.Date visitTime){
		this.visitTime = visitTime;
	}
}
