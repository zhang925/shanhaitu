package com.sht.entity.articategory;

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
 * @Description: 文章分类
 * @author zhangdaihao
 * @date 2018-05-29 21:56:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_arti_category", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ArtiCategoryEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**分类名字*/
	private java.lang.String categoryName;

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
	 *@return: java.lang.String  分类名字
	 */
	@Column(name ="CATEGORY_NAME",nullable=true,length=32)
	public java.lang.String getCategoryName(){
		return this.categoryName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类名字
	 */
	public void setCategoryName(java.lang.String categoryName){
		this.categoryName = categoryName;
	}

	@Column(name ="ORDERS",nullable=true,length=11)
	public double getOrders() {
		return orders;
	}

	public void setOrders(double orders) {
		this.orders = orders;
	}
}
