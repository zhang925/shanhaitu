package com.sht.entity.fileinfo;

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
 * @Description: 山海图文件信息
 * @author zhangdaihao
 * @date 2018-06-14 13:37:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_file_info", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class FileInfoEntity implements java.io.Serializable {
	/**ID*/
	private java.lang.String id;
	/**附件原始名称*/
	private java.lang.String fileOriginName;
	/**附件名称*/
	private java.lang.String fileName;
	/**附件大小*/
	private java.lang.Integer fileSize;
	/**附件大小的单位*/
	private java.lang.Integer fileSizeUnit;
	/**创建时间*/
	private java.util.Date createDate;
	/**扩展名*/
	private java.lang.String extend;
	/**附件路径*/
	private java.lang.String realpath;
	/**用户ID*/
	private java.lang.String userid;
	/**用户名字*/
	private java.lang.String user;
	/**对应模块*/
	private java.lang.String modular;
	/**实体类名字，一定要和实体照应*/
	private java.lang.String className;
	/**对应表的名字*/
	private java.lang.String tableName;
	/**对应数据的id*/
	private java.lang.String columnid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ID
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
	 *@param: java.lang.String  ID
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件原始名称
	 */
	@Column(name ="FILE_ORIGIN_NAME",nullable=true,length=100)
	public java.lang.String getFileOriginName(){
		return this.fileOriginName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件原始名称
	 */
	public void setFileOriginName(java.lang.String fileOriginName){
		this.fileOriginName = fileOriginName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件名称
	 */
	@Column(name ="FILE_NAME",nullable=true,length=100)
	public java.lang.String getFileName(){
		return this.fileName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件名称
	 */
	public void setFileName(java.lang.String fileName){
		this.fileName = fileName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  附件大小
	 */
	@Column(name ="FILE_SIZE",nullable=true,precision=10,scale=0)
	public java.lang.Integer getFileSize(){
		return this.fileSize;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  附件大小
	 */
	public void setFileSize(java.lang.Integer fileSize){
		this.fileSize = fileSize;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  附件大小的单位
	 */
	@Column(name ="FILE_SIZE_UNIT",nullable=true,precision=10,scale=0)
	public java.lang.Integer getFileSizeUnit(){
		return this.fileSizeUnit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  附件大小的单位
	 */
	public void setFileSizeUnit(java.lang.Integer fileSizeUnit){
		this.fileSizeUnit = fileSizeUnit;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扩展名
	 */
	@Column(name ="EXTEND",nullable=true,length=32)
	public java.lang.String getExtend(){
		return this.extend;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扩展名
	 */
	public void setExtend(java.lang.String extend){
		this.extend = extend;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件路径
	 */
	@Column(name ="REALPATH",nullable=true,length=800)
	public java.lang.String getRealpath(){
		return this.realpath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件路径
	 */
	public void setRealpath(java.lang.String realpath){
		this.realpath = realpath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户ID
	 */
	@Column(name ="USERID",nullable=true,length=32)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名字
	 */
	@Column(name ="USER",nullable=true,length=255)
	public java.lang.String getUser(){
		return this.user;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名字
	 */
	public void setUser(java.lang.String user){
		this.user = user;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应模块
	 */
	@Column(name ="MODULAR",nullable=true,length=255)
	public java.lang.String getModular(){
		return this.modular;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应模块
	 */
	public void setModular(java.lang.String modular){
		this.modular = modular;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实体类名字，一定要和实体照应
	 */
	@Column(name ="CLASS_NAME",nullable=true,length=255)
	public java.lang.String getClassName(){
		return this.className;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实体类名字，一定要和实体照应
	 */
	public void setClassName(java.lang.String className){
		this.className = className;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应表的名字
	 */
	@Column(name ="TABLE_NAME",nullable=true,length=255)
	public java.lang.String getTableName(){
		return this.tableName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应表的名字
	 */
	public void setTableName(java.lang.String tableName){
		this.tableName = tableName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应数据的id
	 */
	@Column(name ="COLUMNID",nullable=true,length=255)
	public java.lang.String getColumnid(){
		return this.columnid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应数据的id
	 */
	public void setColumnid(java.lang.String columnid){
		this.columnid = columnid;
	}
}
