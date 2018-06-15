package com.sht.entity.lawdoccatalog;

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
 * @Description: 政策法规目录
 * @author zhangdaihao
 * @date 2018-06-15 11:56:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_law_doc_catalog", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LawdocCatalogEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**父级ID*/
	private java.lang.String parentId;
	/**标题*/
	private java.lang.String title;
	/**所属层级*/
	private java.lang.Integer level;
	/**是否有子节点*/
	private java.lang.String haveLeaf;
	/**排序*/
	private double orders;
	
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
	 *@return: java.lang.String  父级ID
	 */
	@Column(name ="PARENT_ID",nullable=true,length=32)
	public java.lang.String getParentId(){
		return this.parentId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父级ID
	 */
	public void setParentId(java.lang.String parentId){
		this.parentId = parentId;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  所属层级
	 */
	@Column(name ="LEVEL",nullable=true,precision=10,scale=0)
	public java.lang.Integer getLevel(){
		return this.level;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  所属层级
	 */
	public void setLevel(java.lang.Integer level){
		this.level = level;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否有子节点
	 */
	@Column(name ="HAVE_LEAF",nullable=true,length=10)
	public java.lang.String getHaveLeaf(){
		return this.haveLeaf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否有子节点
	 */
	public void setHaveLeaf(java.lang.String haveLeaf){
		this.haveLeaf = haveLeaf;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	@Column(name ="ORDERS",nullable=true,precision=10,scale=0)
	public double getOrders(){
		return this.orders;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setOrders(double orders){
		this.orders = orders;
	}
}
