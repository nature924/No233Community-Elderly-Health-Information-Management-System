package com.entity.model;

import com.entity.YibaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医保信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YibaoModel implements Serializable {
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
     * 医保信息名称
     */
    private String yibaoName;


    /**
     * 医保类型
     */
    private Integer yibaoTypes;


    /**
     * 医保信息编号
     */
    private String yibaoUuidNumber;


    /**
     * 医保信息照片
     */
    private String yibaoPhoto;


    /**
     * 医保信息介绍
     */
    private String yibaoContent;


    /**
     * 逻辑删除
     */
    private Integer yibaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
