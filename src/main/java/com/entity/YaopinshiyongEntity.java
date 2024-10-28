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
 * 药品使用
 *
 * @author 
 * @email
 */
@TableName("yaopinshiyong")
public class YaopinshiyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaopinshiyongEntity() {

	}

	public YaopinshiyongEntity(T t) {
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
     * 药品
     */
    @ColumnInfo(comment="药品",type="int(11)")
    @TableField(value = "yaopin_id")

    private Integer yaopinId;


    /**
     * 病人
     */
    @ColumnInfo(comment="病人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 医生
     */
    @ColumnInfo(comment="医生",type="int(11)")
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 药品使用编号
     */
    @ColumnInfo(comment="药品使用编号",type="varchar(200)")
    @TableField(value = "yaopinshiyong_uuid_number")

    private String yaopinshiyongUuidNumber;


    /**
     * 使用数量
     */
    @ColumnInfo(comment="使用数量",type="int(11)")
    @TableField(value = "yaopinshiyong_number")

    private Integer yaopinshiyongNumber;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="使用时间",type="timestamp")
    @TableField(value = "caozuo_time")

    private Date caozuoTime;


    /**
     * 使用备注
     */
    @ColumnInfo(comment="使用备注",type="text")
    @TableField(value = "yaopinshiyong_content")

    private String yaopinshiyongContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yaopinshiyong{" +
            ", id=" + id +
            ", yaopinId=" + yaopinId +
            ", yonghuId=" + yonghuId +
            ", yishengId=" + yishengId +
            ", yaopinshiyongUuidNumber=" + yaopinshiyongUuidNumber +
            ", yaopinshiyongNumber=" + yaopinshiyongNumber +
            ", caozuoTime=" + DateUtil.convertString(caozuoTime,"yyyy-MM-dd") +
            ", yaopinshiyongContent=" + yaopinshiyongContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
