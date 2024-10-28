package com.entity.model;

import com.entity.JiankangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健康信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 健康信息名称
     */
    private String jiankangName;


    /**
     * 健康类型
     */
    private Integer jiankangTypes;


    /**
     * 身体指标
     */
    private String jiankangZhibiao;


    /**
     * 血压
     */
    private Integer jiankangXueya;


    /**
     * 心率
     */
    private Integer jiankangXinlv;


    /**
     * 健康信息编号
     */
    private String jiankangUuidNumber;


    /**
     * 健康信息照片
     */
    private String jiankangPhoto;


    /**
     * 健康信息介绍
     */
    private String jiankangContent;


    /**
     * 逻辑删除
     */
    private Integer jiankangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
