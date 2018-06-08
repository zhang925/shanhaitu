package com.sht.entity.selectedarticles;

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
 * @Description: 精选文章
 * @author zhangdaihao
 * @date 2018-06-08 11:45:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_selected_articles", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SelectedArticlesEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**文章新闻ID*/
	private java.lang.String articleId;
	/**发布时间*/
	private java.util.Date publishTime;
	/**下架时间*/
	private java.util.Date closingTime;
	/**排序*/
	private java.lang.Integer orders;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=255)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public java.util.Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setPublishTime(java.util.Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下架时间
	 */
	@Column(name ="CLOSING_TIME",nullable=true)
	public java.util.Date getClosingTime(){
		return this.closingTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  下架时间
	 */
	public void setClosingTime(java.util.Date closingTime){
		this.closingTime = closingTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排序
	 */
	@Column(name ="ORDERS",nullable=true,length=11)
	public java.lang.Integer getOrders(){
		return this.orders;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排序
	 */
	public void setOrders(java.lang.Integer orders){
		this.orders = orders;
	}

	@Column(name ="ARTICLE_ID",nullable=true,length=11)
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
}
