package com.entity.vo;

import com.entity.YaopinshiyongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药品使用
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaopinshiyong")
public class YaopinshiyongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药品
     */

    @TableField(value = "yaopin_id")
    private Integer yaopinId;


    /**
     * 病人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 药品使用编号
     */

    @TableField(value = "yaopinshiyong_uuid_number")
    private String yaopinshiyongUuidNumber;


    /**
     * 使用数量
     */

    @TableField(value = "yaopinshiyong_number")
    private Integer yaopinshiyongNumber;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "caozuo_time")
    private Date caozuoTime;


    /**
     * 使用备注
     */

    @TableField(value = "yaopinshiyong_content")
    private String yaopinshiyongContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：药品
	 */
    public Integer getYaopinId() {
        return yaopinId;
    }


    /**
	 * 获取：药品
	 */

    public void setYaopinId(Integer yaopinId) {
        this.yaopinId = yaopinId;
    }
    /**
	 * 设置：病人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：病人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：药品使用编号
	 */
    public String getYaopinshiyongUuidNumber() {
        return yaopinshiyongUuidNumber;
    }


    /**
	 * 获取：药品使用编号
	 */

    public void setYaopinshiyongUuidNumber(String yaopinshiyongUuidNumber) {
        this.yaopinshiyongUuidNumber = yaopinshiyongUuidNumber;
    }
    /**
	 * 设置：使用数量
	 */
    public Integer getYaopinshiyongNumber() {
        return yaopinshiyongNumber;
    }


    /**
	 * 获取：使用数量
	 */

    public void setYaopinshiyongNumber(Integer yaopinshiyongNumber) {
        this.yaopinshiyongNumber = yaopinshiyongNumber;
    }
    /**
	 * 设置：使用时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 获取：使用时间
	 */

    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 设置：使用备注
	 */
    public String getYaopinshiyongContent() {
        return yaopinshiyongContent;
    }


    /**
	 * 获取：使用备注
	 */

    public void setYaopinshiyongContent(String yaopinshiyongContent) {
        this.yaopinshiyongContent = yaopinshiyongContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
