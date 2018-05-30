package com.sht.entity.articlenews;

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
 * @Description: 文章新闻
 * @author zhangdaihao
 * @date 2018-05-29 21:53:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_article_news", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ArticleNewsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**标题*/
	private java.lang.String title;
	/**概要*/
	private java.lang.String summary;
	/**内容*/
	private java.lang.String content;
	/**作者*/
	private java.lang.String author;
	/**创建者ID*/
	private java.lang.String creatorId;
	/**修改者ID*/
	private java.lang.String editorId;
	/**创建者名字*/
	private java.lang.String creator;
	/**修改者名字*/
	private java.lang.String editor;
	/**创建时间*/
	private java.util.Date createdTime;
	/**分类ID*/
	private java.lang.String cateId;
	/**状态*/
	private java.lang.String status;
	
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
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=false,length=512)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  概要
	 */
	@Column(name ="SUMMARY",nullable=true,length=50000)
	public java.lang.String getSummary(){
		return this.summary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  概要
	 */
	public void setSummary(java.lang.String summary){
		this.summary = summary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=50000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作者
	 */
	@Column(name ="AUTHOR",nullable=true,length=256)
	public java.lang.String getAuthor(){
		return this.author;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作者
	 */
	public void setAuthor(java.lang.String author){
		this.author = author;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建者ID
	 */
	@Column(name ="CREATOR_ID",nullable=true,length=32)
	public java.lang.String getCreatorId(){
		return this.creatorId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建者ID
	 */
	public void setCreatorId(java.lang.String creatorId){
		this.creatorId = creatorId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改者ID
	 */
	@Column(name ="EDITOR_ID",nullable=true,length=32)
	public java.lang.String getEditorId(){
		return this.editorId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改者ID
	 */
	public void setEditorId(java.lang.String editorId){
		this.editorId = editorId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建者名字
	 */
	@Column(name ="CREATOR",nullable=true,length=256)
	public java.lang.String getCreator(){
		return this.creator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建者名字
	 */
	public void setCreator(java.lang.String creator){
		this.creator = creator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改者名字
	 */
	@Column(name ="EDITOR",nullable=true,length=256)
	public java.lang.String getEditor(){
		return this.editor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改者名字
	 */
	public void setEditor(java.lang.String editor){
		this.editor = editor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATED_TIME",nullable=true)
	public java.util.Date getCreatedTime(){
		return this.createdTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatedTime(java.util.Date createdTime){
		this.createdTime = createdTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类ID
	 */
	@Column(name ="CATE_ID",nullable=true,length=32)
	public java.lang.String getCateId(){
		return this.cateId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类ID
	 */
	public void setCateId(java.lang.String cateId){
		this.cateId = cateId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATUS",nullable=true,length=32)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
}
