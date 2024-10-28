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
 * 健康信息
 *
 * @author 
 * @email
 */
@TableName("jiankang")
public class JiankangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangEntity() {

	}

	public JiankangEntity(T t) {
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
     * 健康信息名称
     */
    @ColumnInfo(comment="健康信息名称",type="varchar(200)")
    @TableField(value = "jiankang_name")

    private String jiankangName;


    /**
     * 健康类型
     */
    @ColumnInfo(comment="健康类型",type="int(11)")
    @TableField(value = "jiankang_types")

    private Integer jiankangTypes;


    /**
     * 身体指标
     */
    @ColumnInfo(comment="身体指标",type="varchar(200)")
    @TableField(value = "jiankang_zhibiao")

    private String jiankangZhibiao;


    /**
     * 血压
     */
    @ColumnInfo(comment="血压",type="int(11)")
    @TableField(value = "jiankang_xueya")

    private Integer jiankangXueya;


    /**
     * 心率
     */
    @ColumnInfo(comment="心率",type="int(11)")
    @TableField(value = "jiankang_xinlv")

    private Integer jiankangXinlv;


    /**
     * 健康信息编号
     */
    @ColumnInfo(comment="健康信息编号",type="varchar(200)")
    @TableField(value = "jiankang_uuid_number")

    private String jiankangUuidNumber;


    /**
     * 健康信息照片
     */
    @ColumnInfo(comment="健康信息照片",type="varchar(200)")
    @TableField(value = "jiankang_photo")

    private String jiankangPhoto;


    /**
     * 健康信息介绍
     */
    @ColumnInfo(comment="健康信息介绍",type="longtext")
    @TableField(value = "jiankang_content")

    private String jiankangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiankang_delete")

    private Integer jiankangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：健康信息名称
	 */
    public String getJiankangName() {
        return jiankangName;
    }
    /**
	 * 设置：健康信息名称
	 */

    public void setJiankangName(String jiankangName) {
        this.jiankangName = jiankangName;
    }
    /**
	 * 获取：健康类型
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }
    /**
	 * 设置：健康类型
	 */

    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 获取：身体指标
	 */
    public String getJiankangZhibiao() {
        return jiankangZhibiao;
    }
    /**
	 * 设置：身体指标
	 */

    public void setJiankangZhibiao(String jiankangZhibiao) {
        this.jiankangZhibiao = jiankangZhibiao;
    }
    /**
	 * 获取：血压
	 */
    public Integer getJiankangXueya() {
        return jiankangXueya;
    }
    /**
	 * 设置：血压
	 */

    public void setJiankangXueya(Integer jiankangXueya) {
        this.jiankangXueya = jiankangXueya;
    }
    /**
	 * 获取：心率
	 */
    public Integer getJiankangXinlv() {
        return jiankangXinlv;
    }
    /**
	 * 设置：心率
	 */

    public void setJiankangXinlv(Integer jiankangXinlv) {
        this.jiankangXinlv = jiankangXinlv;
    }
    /**
	 * 获取：健康信息编号
	 */
    public String getJiankangUuidNumber() {
        return jiankangUuidNumber;
    }
    /**
	 * 设置：健康信息编号
	 */

    public void setJiankangUuidNumber(String jiankangUuidNumber) {
        this.jiankangUuidNumber = jiankangUuidNumber;
    }
    /**
	 * 获取：健康信息照片
	 */
    public String getJiankangPhoto() {
        return jiankangPhoto;
    }
    /**
	 * 设置：健康信息照片
	 */

    public void setJiankangPhoto(String jiankangPhoto) {
        this.jiankangPhoto = jiankangPhoto;
    }
    /**
	 * 获取：健康信息介绍
	 */
    public String getJiankangContent() {
        return jiankangContent;
    }
    /**
	 * 设置：健康信息介绍
	 */

    public void setJiankangContent(String jiankangContent) {
        this.jiankangContent = jiankangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiankangDelete() {
        return jiankangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiankangDelete(Integer jiankangDelete) {
        this.jiankangDelete = jiankangDelete;
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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiankang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yishengId=" + yishengId +
            ", jiankangName=" + jiankangName +
            ", jiankangTypes=" + jiankangTypes +
            ", jiankangZhibiao=" + jiankangZhibiao +
            ", jiankangXueya=" + jiankangXueya +
            ", jiankangXinlv=" + jiankangXinlv +
            ", jiankangUuidNumber=" + jiankangUuidNumber +
            ", jiankangPhoto=" + jiankangPhoto +
            ", jiankangContent=" + jiankangContent +
            ", jiankangDelete=" + jiankangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
