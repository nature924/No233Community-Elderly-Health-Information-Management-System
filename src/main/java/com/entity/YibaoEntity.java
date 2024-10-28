package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 医保信息
 *
 * @author 
 * @email
 */
@TableName("yibao")
public class YibaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YibaoEntity() {

	}

	public YibaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 医生
     */
    @ColumnInfo(comment="医生",type="int(11)")
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 医保信息名称
     */
    @ColumnInfo(comment="医保信息名称",type="varchar(200)")
    @TableField(value = "yibao_name")

    private String yibaoName;


    /**
     * 医保类型
     */
    @ColumnInfo(comment="医保类型",type="int(11)")
    @TableField(value = "yibao_types")

    private Integer yibaoTypes;


    /**
     * 医保信息编号
     */
    @ColumnInfo(comment="医保信息编号",type="varchar(200)")
    @TableField(value = "yibao_uuid_number")

    private String yibaoUuidNumber;


    /**
     * 医保信息照片
     */
    @ColumnInfo(comment="医保信息照片",type="varchar(200)")
    @TableField(value = "yibao_photo")

    private String yibaoPhoto;


    /**
     * 医保信息介绍
     */
    @ColumnInfo(comment="医保信息介绍",type="longtext")
    @TableField(value = "yibao_content")

    private String yibaoContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yibao_delete")

    private Integer yibaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }
    /**
	 * 设置：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：医保信息名称
	 */
    public String getYibaoName() {
        return yibaoName;
    }
    /**
	 * 设置：医保信息名称
	 */

    public void setYibaoName(String yibaoName) {
        this.yibaoName = yibaoName;
    }
    /**
	 * 获取：医保类型
	 */
    public Integer getYibaoTypes() {
        return yibaoTypes;
    }
    /**
	 * 设置：医保类型
	 */

    public void setYibaoTypes(Integer yibaoTypes) {
        this.yibaoTypes = yibaoTypes;
    }
    /**
	 * 获取：医保信息编号
	 */
    public String getYibaoUuidNumber() {
        return yibaoUuidNumber;
    }
    /**
	 * 设置：医保信息编号
	 */

    public void setYibaoUuidNumber(String yibaoUuidNumber) {
        this.yibaoUuidNumber = yibaoUuidNumber;
    }
    /**
	 * 获取：医保信息照片
	 */
    public String getYibaoPhoto() {
        return yibaoPhoto;
    }
    /**
	 * 设置：医保信息照片
	 */

    public void setYibaoPhoto(String yibaoPhoto) {
        this.yibaoPhoto = yibaoPhoto;
    }
    /**
	 * 获取：医保信息介绍
	 */
    public String getYibaoContent() {
        return yibaoContent;
    }
    /**
	 * 设置：医保信息介绍
	 */

    public void setYibaoContent(String yibaoContent) {
        this.yibaoContent = yibaoContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYibaoDelete() {
        return yibaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYibaoDelete(Integer yibaoDelete) {
        this.yibaoDelete = yibaoDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yibao{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yishengId=" + yishengId +
            ", yibaoName=" + yibaoName +
            ", yibaoTypes=" + yibaoTypes +
            ", yibaoUuidNumber=" + yibaoUuidNumber +
            ", yibaoPhoto=" + yibaoPhoto +
            ", yibaoContent=" + yibaoContent +
            ", yibaoDelete=" + yibaoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
