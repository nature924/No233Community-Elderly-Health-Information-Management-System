package com.entity.model;

import com.entity.BingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 就诊历史
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 病例编号
     */
    private String bingliUuidNumber;


    /**
     * 病人
     */
    private Integer yonghuId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 检查时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jianchaTime;


    /**
     * 病人自述
     */
    private String bingrenzishuContent;


    /**
     * 检查结果
     */
    private String jianchajieguoContent;


    /**
     * 医生开方
     */
    private String yishengkaifangContent;


    /**
     * 医生建议
     */
    private String yishengjianyiContent;


    /**
     * 下次就诊时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiacijiuzhenTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：病例编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }


    /**
	 * 设置：病例编号
	 */
    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
    }
    /**
	 * 获取：病人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：病人
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
	 * 获取：检查时间
	 */
    public Date getJianchaTime() {
        return jianchaTime;
    }


    /**
	 * 设置：检查时间
	 */
    public void setJianchaTime(Date jianchaTime) {
        this.jianchaTime = jianchaTime;
    }
    /**
	 * 获取：病人自述
	 */
    public String getBingrenzishuContent() {
        return bingrenzishuContent;
    }


    /**
	 * 设置：病人自述
	 */
    public void setBingrenzishuContent(String bingrenzishuContent) {
        this.bingrenzishuContent = bingrenzishuContent;
    }
    /**
	 * 获取：检查结果
	 */
    public String getJianchajieguoContent() {
        return jianchajieguoContent;
    }


    /**
	 * 设置：检查结果
	 */
    public void setJianchajieguoContent(String jianchajieguoContent) {
        this.jianchajieguoContent = jianchajieguoContent;
    }
    /**
	 * 获取：医生开方
	 */
    public String getYishengkaifangContent() {
        return yishengkaifangContent;
    }


    /**
	 * 设置：医生开方
	 */
    public void setYishengkaifangContent(String yishengkaifangContent) {
        this.yishengkaifangContent = yishengkaifangContent;
    }
    /**
	 * 获取：医生建议
	 */
    public String getYishengjianyiContent() {
        return yishengjianyiContent;
    }


    /**
	 * 设置：医生建议
	 */
    public void setYishengjianyiContent(String yishengjianyiContent) {
        this.yishengjianyiContent = yishengjianyiContent;
    }
    /**
	 * 获取：下次就诊时间
	 */
    public Date getXiacijiuzhenTime() {
        return xiacijiuzhenTime;
    }


    /**
	 * 设置：下次就诊时间
	 */
    public void setXiacijiuzhenTime(Date xiacijiuzhenTime) {
        this.xiacijiuzhenTime = xiacijiuzhenTime;
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
