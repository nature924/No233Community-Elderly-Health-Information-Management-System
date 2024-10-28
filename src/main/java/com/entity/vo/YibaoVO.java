package com.entity.vo;

import com.entity.YibaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医保信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yibao")
public class YibaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 医保信息名称
     */

    @TableField(value = "yibao_name")
    private String yibaoName;


    /**
     * 医保类型
     */

    @TableField(value = "yibao_types")
    private Integer yibaoTypes;


    /**
     * 医保信息编号
     */

    @TableField(value = "yibao_uuid_number")
    private String yibaoUuidNumber;


    /**
     * 医保信息照片
     */

    @TableField(value = "yibao_photo")
    private String yibaoPhoto;


    /**
     * 医保信息介绍
     */

    @TableField(value = "yibao_content")
    private String yibaoContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yibao_delete")
    private Integer yibaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
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
	 * 设置：医保信息名称
	 */
    public String getYibaoName() {
        return yibaoName;
    }


    /**
	 * 获取：医保信息名称
	 */

    public void setYibaoName(String yibaoName) {
        this.yibaoName = yibaoName;
    }
    /**
	 * 设置：医保类型
	 */
    public Integer getYibaoTypes() {
        return yibaoTypes;
    }


    /**
	 * 获取：医保类型
	 */

    public void setYibaoTypes(Integer yibaoTypes) {
        this.yibaoTypes = yibaoTypes;
    }
    /**
	 * 设置：医保信息编号
	 */
    public String getYibaoUuidNumber() {
        return yibaoUuidNumber;
    }


    /**
	 * 获取：医保信息编号
	 */

    public void setYibaoUuidNumber(String yibaoUuidNumber) {
        this.yibaoUuidNumber = yibaoUuidNumber;
    }
    /**
	 * 设置：医保信息照片
	 */
    public String getYibaoPhoto() {
        return yibaoPhoto;
    }


    /**
	 * 获取：医保信息照片
	 */

    public void setYibaoPhoto(String yibaoPhoto) {
        this.yibaoPhoto = yibaoPhoto;
    }
    /**
	 * 设置：医保信息介绍
	 */
    public String getYibaoContent() {
        return yibaoContent;
    }


    /**
	 * 获取：医保信息介绍
	 */

    public void setYibaoContent(String yibaoContent) {
        this.yibaoContent = yibaoContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYibaoDelete() {
        return yibaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYibaoDelete(Integer yibaoDelete) {
        this.yibaoDelete = yibaoDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
