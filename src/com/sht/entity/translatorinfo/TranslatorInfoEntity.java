package com.sht.entity.translatorinfo;

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
 * @Description: 翻译人员信息
 * @author zhangdaihao
 * @date 2018-06-13 17:01:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_translator_info", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TranslatorInfoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**姓名*/
	private java.lang.String name;
	/**性别*/
	private java.lang.String sex;
	/**地址*/
	private java.lang.String address;
	/**身份证号*/
	private java.lang.String identityId;
	/**电话1*/
	private java.lang.String phone1;
	/**电话2*/
	private java.lang.String phone2;
	/**邮箱*/
	private java.lang.String email;
	/**一种交流工具whatsapp*/
	private java.lang.String whatsapp;
	/**微信*/
	private java.lang.String wechat;
	/**头像地址*/
	private java.lang.String pictureUrl;
	/**学校*/
	private java.lang.String college;
	/**学历*/
	private java.lang.String educationBg;
	/**工作年限*/
	private java.lang.Integer workYears;
	/**工作经历*/
	private java.lang.String workExper;
	/**中文水平*/
	private java.lang.String chineseLevel;
	/**印度语水平*/
	private java.lang.String indonesianLevel;
	/**英语水平*/
	private java.lang.String englishLevel;
	/**其他语言*/
	private java.lang.String otherLang;
	/**评定等级*/
	private java.lang.String ratings;
	
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=255)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=10)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=255)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="IDENTITY_ID",nullable=true,length=50)
	public java.lang.String getIdentityId(){
		return this.identityId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdentityId(java.lang.String identityId){
		this.identityId = identityId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话1
	 */
	@Column(name ="PHONE1",nullable=true,length=20)
	public java.lang.String getPhone1(){
		return this.phone1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话1
	 */
	public void setPhone1(java.lang.String phone1){
		this.phone1 = phone1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话2
	 */
	@Column(name ="PHONE2",nullable=true,length=20)
	public java.lang.String getPhone2(){
		return this.phone2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话2
	 */
	public void setPhone2(java.lang.String phone2){
		this.phone2 = phone2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */
	@Column(name ="EMAIL",nullable=true,length=255)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  一种交流工具whatsapp
	 */
	@Column(name ="WHATSAPP",nullable=true,length=255)
	public java.lang.String getWhatsapp(){
		return this.whatsapp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  一种交流工具whatsapp
	 */
	public void setWhatsapp(java.lang.String whatsapp){
		this.whatsapp = whatsapp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信
	 */
	@Column(name ="WECHAT",nullable=true,length=255)
	public java.lang.String getWechat(){
		return this.wechat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信
	 */
	public void setWechat(java.lang.String wechat){
		this.wechat = wechat;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像地址
	 */
	@Column(name ="PICTURE_URL",nullable=true,length=255)
	public java.lang.String getPictureUrl(){
		return this.pictureUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像地址
	 */
	public void setPictureUrl(java.lang.String pictureUrl){
		this.pictureUrl = pictureUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校
	 */
	@Column(name ="COLLEGE",nullable=true,length=255)
	public java.lang.String getCollege(){
		return this.college;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校
	 */
	public void setCollege(java.lang.String college){
		this.college = college;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	@Column(name ="EDUCATION_BG",nullable=true,length=255)
	public java.lang.String getEducationBg(){
		return this.educationBg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducationBg(java.lang.String educationBg){
		this.educationBg = educationBg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  工作年限
	 */
	@Column(name ="WORK_YEARS",nullable=true,precision=10,scale=0)
	public java.lang.Integer getWorkYears(){
		return this.workYears;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  工作年限
	 */
	public void setWorkYears(java.lang.Integer workYears){
		this.workYears = workYears;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作经历
	 */
	@Column(name ="WORK_EXPER",nullable=true,length=5000)
	public java.lang.String getWorkExper(){
		return this.workExper;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作经历
	 */
	public void setWorkExper(java.lang.String workExper){
		this.workExper = workExper;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中文水平
	 */
	@Column(name ="CHINESE_LEVEL",nullable=true,length=255)
	public java.lang.String getChineseLevel(){
		return this.chineseLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中文水平
	 */
	public void setChineseLevel(java.lang.String chineseLevel){
		this.chineseLevel = chineseLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  印度语水平
	 */
	@Column(name ="INDONESIAN_LEVEL",nullable=true,length=255)
	public java.lang.String getIndonesianLevel(){
		return this.indonesianLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  印度语水平
	 */
	public void setIndonesianLevel(java.lang.String indonesianLevel){
		this.indonesianLevel = indonesianLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  英语水平
	 */
	@Column(name ="ENGLISH_LEVEL",nullable=true,length=255)
	public java.lang.String getEnglishLevel(){
		return this.englishLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  英语水平
	 */
	public void setEnglishLevel(java.lang.String englishLevel){
		this.englishLevel = englishLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他语言
	 */
	@Column(name ="OTHER_LANG",nullable=true,length=255)
	public java.lang.String getOtherLang(){
		return this.otherLang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他语言
	 */
	public void setOtherLang(java.lang.String otherLang){
		this.otherLang = otherLang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评定等级
	 */
	@Column(name ="RATINGS",nullable=true,length=255)
	public java.lang.String getRatings(){
		return this.ratings;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评定等级
	 */
	public void setRatings(java.lang.String ratings){
		this.ratings = ratings;
	}
}
