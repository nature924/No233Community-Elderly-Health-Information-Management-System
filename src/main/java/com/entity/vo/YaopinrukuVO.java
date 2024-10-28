package com.entity.vo;

import com.entity.YaopinrukuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药品入库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaopinruku")
public class YaopinrukuVO implements Serializable {
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
     * 药品入库编号
     */

    @TableField(value = "yaopinruku_uuid_number")
    private String yaopinrukuUuidNumber;


    /**
     * 入库数量
     */

    @TableField(value = "yaopinruku_number")
    private Integer yaopinrukuNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "caozuo_time")
    private Date caozuoTime;


    /**
     * 入库备注
     */

    @TableField(value = "yaopinruku_content")
    private String yaopinrukuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：药品入库编号
	 */
    public String getYaopinrukuUuidNumber() {
        return yaopinrukuUuidNumber;
    }


    /**
	 * 获取：药品入库编号
	 */

    public void setYaopinrukuUuidNumber(String yaopinrukuUuidNumber) {
        this.yaopinrukuUuidNumber = yaopinrukuUuidNumber;
    }
    /**
	 * 设置：入库数量
	 */
    public Integer getYaopinrukuNumber() {
        return yaopinrukuNumber;
    }


    /**
	 * 获取：入库数量
	 */

    public void setYaopinrukuNumber(Integer yaopinrukuNumber) {
        this.yaopinrukuNumber = yaopinrukuNumber;
    }
    /**
	 * 设置：入库时间
	 */
    public Date getCaozuoTime() {
        return caozuoTime;
    }


    /**
	 * 获取：入库时间
	 */

    public void setCaozuoTime(Date caozuoTime) {
        this.caozuoTime = caozuoTime;
    }
    /**
	 * 设置：入库备注
	 */
    public String getYaopinrukuContent() {
        return yaopinrukuContent;
    }


    /**
	 * 获取：入库备注
	 */

    public void setYaopinrukuContent(String yaopinrukuContent) {
        this.yaopinrukuContent = yaopinrukuContent;
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
