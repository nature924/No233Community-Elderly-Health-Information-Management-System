package com.entity.model;

import com.entity.YaopinshiyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 药品使用
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YaopinshiyongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 药品
     */
    private Integer yaopinId;


    /**
     * 病人
     */
    private Integer yonghuId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 药品使用编号
     */
    private String yaopinshiyongUuidNumber;


    /**
     * 使用数量
     */
    private Integer yaopinshiyongNumber;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date caozuoTime;


    /**
     * 使用备注
     */
    private String yaopinshiyongContent;


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
	 * 获取：药品
	 */
    public Integer getYaopinId() {
        return yaopinId;
    }


    /**
	 * 设置：药品
	 */
    public void setYaopinId(Integer yaopinId) {
        this.yaopinId = yaopinId;
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
	 * 获取：药品使用编号
	 */
    public String getYaopinshiyongUuidNumber() {
        return yaopinshiyongUuidNumber;
    }


    /**
	 * 设置：药品使用编号
	 */
    public void setYaopinshiyongUuidNumber(String yaopinshiyongUuidNumber) {
        this.yaopinshiyongUuidNumber = yaopinshiyongUuidNumber;
    }
    /**
	 * 获取：使用数量
	 */
    public Integer getYaopinshiyongNumber() {
        return yaopinshiyongNumber;
    }


    /**
	 * 设置：使用数量
	 */
    public void setYaopinshiyongNumber(Integer yaopinshiyongNumber) {
        this.yaopinshiyongNumber = yaopinshiyongNumber;
    }
    /**
	 * 获取：使用时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 设置：使用时间
	 */
    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 获取：使用备注
	 */
    public String getYaopinshiyongContent() {
        return yaopinshiyongContent;
    }


    /**
	 * 设置：使用备注
	 */
    public void setYaopinshiyongContent(String yaopinshiyongContent) {
        this.yaopinshiyongContent = yaopinshiyongContent;
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
