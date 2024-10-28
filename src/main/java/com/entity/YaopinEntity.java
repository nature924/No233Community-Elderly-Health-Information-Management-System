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
 * 药品
 *
 * @author 
 * @email
 */
@TableName("yaopin")
public class YaopinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaopinEntity() {

	}

	public YaopinEntity(T t) {
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
     * 药品名称
     */
    @ColumnInfo(comment="药品名称",type="varchar(200)")
    @TableField(value = "yaopin_name")

    private String yaopinName;


    /**
     * 药品编号
     */
    @ColumnInfo(comment="药品编号",type="varchar(200)")
    @TableField(value = "yaopin_uuid_number")

    private String yaopinUuidNumber;


    /**
     * 药品照片
     */
    @ColumnInfo(comment="药品照片",type="varchar(200)")
    @TableField(value = "yaopin_photo")

    private String yaopinPhoto;


    /**
     * 生产厂家
     */
    @ColumnInfo(comment="生产厂家",type="varchar(200)")
    @TableField(value = "shengchanchangjia")

    private String shengchanchangjia;


    /**
     * 药品类型
     */
    @ColumnInfo(comment="药品类型",type="int(11)")
    @TableField(value = "yaopin_types")

    private Integer yaopinTypes;


    /**
     * 药品库存
     */
    @ColumnInfo(comment="药品库存",type="int(11)")
    @TableField(value = "yaopin_kucun_number")

    private Integer yaopinKucunNumber;


    /**
     * 药品进价
     */
    @ColumnInfo(comment="药品进价",type="decimal(10,2)")
    @TableField(value = "yaopin_jinjia_money")

    private Double yaopinJinjiaMoney;


    /**
     * 售价
     */
    @ColumnInfo(comment="售价",type="decimal(10,2)")
    @TableField(value = "yaopin_new_money")

    private Double yaopinNewMoney;


    /**
     * 药品功效
     */
    @ColumnInfo(comment="药品功效",type="text")
    @TableField(value = "yaopin_gongxiao_content")

    private String yaopinGongxiaoContent;


    /**
     * 药品禁忌
     */
    @ColumnInfo(comment="药品禁忌",type="text")
    @TableField(value = "yaopin_jinji_content")

    private String yaopinJinjiContent;


    /**
     * 注意事项
     */
    @ColumnInfo(comment="注意事项",type="text")
    @TableField(value = "yaopin_zhuyi_content")

    private String yaopinZhuyiContent;


    /**
     * 药品详情
     */
    @ColumnInfo(comment="药品详情",type="text")
    @TableField(value = "yaopin_content")

    private String yaopinContent;


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
	 * 获取：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }
    /**
	 * 设置：药品名称
	 */

    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 获取：药品编号
	 */
    public String getYaopinUuidNumber() {
        return yaopinUuidNumber;
    }
    /**
	 * 设置：药品编号
	 */

    public void setYaopinUuidNumber(String yaopinUuidNumber) {
        this.yaopinUuidNumber = yaopinUuidNumber;
    }
    /**
	 * 获取：药品照片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }
    /**
	 * 设置：药品照片
	 */

    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
    }
    /**
	 * 获取：生产厂家
	 */
    public String getShengchanchangjia() {
        return shengchanchangjia;
    }
    /**
	 * 设置：生产厂家
	 */

    public void setShengchanchangjia(String shengchanchangjia) {
        this.shengchanchangjia = shengchanchangjia;
    }
    /**
	 * 获取：药品类型
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }
    /**
	 * 设置：药品类型
	 */

    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 获取：药品库存
	 */
    public Integer getYaopinKucunNumber() {
        return yaopinKucunNumber;
    }
    /**
	 * 设置：药品库存
	 */

    public void setYaopinKucunNumber(Integer yaopinKucunNumber) {
        this.yaopinKucunNumber = yaopinKucunNumber;
    }
    /**
	 * 获取：药品进价
	 */
    public Double getYaopinJinjiaMoney() {
        return yaopinJinjiaMoney;
    }
    /**
	 * 设置：药品进价
	 */

    public void setYaopinJinjiaMoney(Double yaopinJinjiaMoney) {
        this.yaopinJinjiaMoney = yaopinJinjiaMoney;
    }
    /**
	 * 获取：售价
	 */
    public Double getYaopinNewMoney() {
        return yaopinNewMoney;
    }
    /**
	 * 设置：售价
	 */

    public void setYaopinNewMoney(Double yaopinNewMoney) {
        this.yaopinNewMoney = yaopinNewMoney;
    }
    /**
	 * 获取：药品功效
	 */
    public String getYaopinGongxiaoContent() {
        return yaopinGongxiaoContent;
    }
    /**
	 * 设置：药品功效
	 */

    public void setYaopinGongxiaoContent(String yaopinGongxiaoContent) {
        this.yaopinGongxiaoContent = yaopinGongxiaoContent;
    }
    /**
	 * 获取：药品禁忌
	 */
    public String getYaopinJinjiContent() {
        return yaopinJinjiContent;
    }
    /**
	 * 设置：药品禁忌
	 */

    public void setYaopinJinjiContent(String yaopinJinjiContent) {
        this.yaopinJinjiContent = yaopinJinjiContent;
    }
    /**
	 * 获取：注意事项
	 */
    public String getYaopinZhuyiContent() {
        return yaopinZhuyiContent;
    }
    /**
	 * 设置：注意事项
	 */

    public void setYaopinZhuyiContent(String yaopinZhuyiContent) {
        this.yaopinZhuyiContent = yaopinZhuyiContent;
    }
    /**
	 * 获取：药品详情
	 */
    public String getYaopinContent() {
        return yaopinContent;
    }
    /**
	 * 设置：药品详情
	 */

    public void setYaopinContent(String yaopinContent) {
        this.yaopinContent = yaopinContent;
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
        return "Yaopin{" +
            ", id=" + id +
            ", yaopinName=" + yaopinName +
            ", yaopinUuidNumber=" + yaopinUuidNumber +
            ", yaopinPhoto=" + yaopinPhoto +
            ", shengchanchangjia=" + shengchanchangjia +
            ", yaopinTypes=" + yaopinTypes +
            ", yaopinKucunNumber=" + yaopinKucunNumber +
            ", yaopinJinjiaMoney=" + yaopinJinjiaMoney +
            ", yaopinNewMoney=" + yaopinNewMoney +
            ", yaopinGongxiaoContent=" + yaopinGongxiaoContent +
            ", yaopinJinjiContent=" + yaopinJinjiContent +
            ", yaopinZhuyiContent=" + yaopinZhuyiContent +
            ", yaopinContent=" + yaopinContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
