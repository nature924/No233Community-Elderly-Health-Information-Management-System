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
 * 药品入库
 *
 * @author 
 * @email
 */
@TableName("yaopinruku")
public class YaopinrukuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaopinrukuEntity() {

	}

	public YaopinrukuEntity(T t) {
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
     * 药品入库编号
     */
    @ColumnInfo(comment="药品入库编号",type="varchar(200)")
    @TableField(value = "yaopinruku_uuid_number")

    private String yaopinrukuUuidNumber;


    /**
     * 入库数量
     */
    @ColumnInfo(comment="入库数量",type="int(11)")
    @TableField(value = "yaopinruku_number")

    private Integer yaopinrukuNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="入库时间",type="timestamp")
    @TableField(value = "caozuo_time")

    private Date caozuoTime;


    /**
     * 入库备注
     */
    @ColumnInfo(comment="入库备注",type="text")
    @TableField(value = "yaopinruku_content")

    private String yaopinrukuContent;


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

    @Override
    public String toString() {
        return "Yaopinruku{" +
            ", id=" + id +
            ", yaopinId=" + yaopinId +
            ", yaopinrukuUuidNumber=" + yaopinrukuUuidNumber +
            ", yaopinrukuNumber=" + yaopinrukuNumber +
            ", caozuoTime=" + DateUtil.convertString(caozuoTime,"yyyy-MM-dd") +
            ", yaopinrukuContent=" + yaopinrukuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
