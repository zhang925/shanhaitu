package com.sht.entity.questionrelationtag;

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
 * @Description: 问题分类和问题关系表
 * @author zhangdaihao
 * @date 2018-06-10 20:22:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_question_relation_tag", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class QuestionRelationTagEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**标签id*/
	private java.lang.String tagId;
	/**问题id*/
	private java.lang.String questionId;
	
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
	 *@return: java.lang.String  标签id
	 */
	@Column(name ="TAG_ID",nullable=true,length=32)
	public java.lang.String getTagId(){
		return this.tagId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标签id
	 */
	public void setTagId(java.lang.String tagId){
		this.tagId = tagId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题id
	 */
	@Column(name ="QUESTION_ID",nullable=true,length=32)
	public java.lang.String getQuestionId(){
		return this.questionId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题id
	 */
	public void setQuestionId(java.lang.String questionId){
		this.questionId = questionId;
	}
}
