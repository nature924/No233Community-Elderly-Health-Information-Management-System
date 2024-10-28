package com.entity.vo;

import com.entity.JiankangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健康信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankang")
public class JiankangVO implements Serializable {
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
     * 健康信息名称
     */

    @TableField(value = "jiankang_name")
    private String jiankangName;


    /**
     * 健康类型
     */

    @TableField(value = "jiankang_types")
    private Integer jiankangTypes;


    /**
     * 身体指标
     */

    @TableField(value = "jiankang_zhibiao")
    private String jiankangZhibiao;


    /**
     * 血压
     */

    @TableField(value = "jiankang_xueya")
    private Integer jiankangXueya;


    /**
     * 心率
     */

    @TableField(value = "jiankang_xinlv")
    private Integer jiankangXinlv;


    /**
     * 健康信息编号
     */

    @TableField(value = "jiankang_uuid_number")
    private String jiankangUuidNumber;


    /**
     * 健康信息照片
     */

    @TableField(value = "jiankang_photo")
    private String jiankangPhoto;


    /**
     * 健康信息介绍
     */

    @TableField(value = "jiankang_content")
    private String jiankangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiankang_delete")
    private Integer jiankangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：健康信息名称
	 */
    public String getJiankangName() {
        return jiankangName;
    }


    /**
	 * 获取：健康信息名称
	 */

    public void setJiankangName(String jiankangName) {
        this.jiankangName = jiankangName;
    }
    /**
	 * 设置：健康类型
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }


    /**
	 * 获取：健康类型
	 */

    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 设置：身体指标
	 */
    public String getJiankangZhibiao() {
        return jiankangZhibiao;
    }


    /**
	 * 获取：身体指标
	 */

    public void setJiankangZhibiao(String jiankangZhibiao) {
        this.jiankangZhibiao = jiankangZhibiao;
    }
    /**
	 * 设置：血压
	 */
    public Integer getJiankangXueya() {
        return jiankangXueya;
    }


    /**
	 * 获取：血压
	 */

    public void setJiankangXueya(Integer jiankangXueya) {
        this.jiankangXueya = jiankangXueya;
    }
    /**
	 * 设置：心率
	 */
    public Integer getJiankangXinlv() {
        return jiankangXinlv;
    }


    /**
	 * 获取：心率
	 */

    public void setJiankangXinlv(Integer jiankangXinlv) {
        this.jiankangXinlv = jiankangXinlv;
    }
    /**
	 * 设置：健康信息编号
	 */
    public String getJiankangUuidNumber() {
        return jiankangUuidNumber;
    }


    /**
	 * 获取：健康信息编号
	 */

    public void setJiankangUuidNumber(String jiankangUuidNumber) {
        this.jiankangUuidNumber = jiankangUuidNumber;
    }
    /**
	 * 设置：健康信息照片
	 */
    public String getJiankangPhoto() {
        return jiankangPhoto;
    }


    /**
	 * 获取：健康信息照片
	 */

    public void setJiankangPhoto(String jiankangPhoto) {
        this.jiankangPhoto = jiankangPhoto;
    }
    /**
	 * 设置：健康信息介绍
	 */
    public String getJiankangContent() {
        return jiankangContent;
    }


    /**
	 * 获取：健康信息介绍
	 */

    public void setJiankangContent(String jiankangContent) {
        this.jiankangContent = jiankangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiankangDelete() {
        return jiankangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiankangDelete(Integer jiankangDelete) {
        this.jiankangDelete = jiankangDelete;
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
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
