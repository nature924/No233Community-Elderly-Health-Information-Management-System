package com.entity.model;

import com.entity.YaopinrukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 药品入库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YaopinrukuModel implements Serializable {
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
     * 药品入库编号
     */
    private String yaopinrukuUuidNumber;


    /**
     * 入库数量
     */
    private Integer yaopinrukuNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date caozuoTime;


    /**
     * 入库备注
     */
    private String yaopinrukuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：药品入库编号
	 */
    public String getYaopinrukuUuidNumber() {
        return yaopinrukuUuidNumber;
    }


    /**
	 * 设置：药品入库编号
	 */
    public void setYaopinrukuUuidNumber(String yaopinrukuUuidNumber) {
        this.yaopinrukuUuidNumber = yaopinrukuUuidNumber;
    }
    /**
	 * 获取：入库数量
	 */
    public Integer getYaopinrukuNumber() {
        return yaopinrukuNumber;
    }


    /**
	 * 设置：入库数量
	 */
    public void setYaopinrukuNumber(Integer yaopinrukuNumber) {
        this.yaopinrukuNumber = yaopinrukuNumber;
    }
    /**
	 * 获取：入库时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 设置：入库时间
	 */
    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 获取：入库备注
	 */
    public String getYaopinrukuContent() {
        return yaopinrukuContent;
    }


    /**
	 * 设置：入库备注
	 */
    public void setYaopinrukuContent(String yaopinrukuContent) {
        this.yaopinrukuContent = yaopinrukuContent;
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

    }
