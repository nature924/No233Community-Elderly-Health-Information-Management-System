package com.entity.vo;

import com.entity.YaopinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaopin")
public class YaopinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药品名称
     */

    @TableField(value = "yaopin_name")
    private String yaopinName;


    /**
     * 药品编号
     */

    @TableField(value = "yaopin_uuid_number")
    private String yaopinUuidNumber;


    /**
     * 药品照片
     */

    @TableField(value = "yaopin_photo")
    private String yaopinPhoto;


    /**
     * 生产厂家
     */

    @TableField(value = "shengchanchangjia")
    private String shengchanchangjia;


    /**
     * 药品类型
     */

    @TableField(value = "yaopin_types")
    private Integer yaopinTypes;


    /**
     * 药品库存
     */

    @TableField(value = "yaopin_kucun_number")
    private Integer yaopinKucunNumber;


    /**
     * 药品进价
     */

    @TableField(value = "yaopin_jinjia_money")
    private Double yaopinJinjiaMoney;


    /**
     * 售价
     */

    @TableField(value = "yaopin_new_money")
    private Double yaopinNewMoney;


    /**
     * 药品功效
     */

    @TableField(value = "yaopin_gongxiao_content")
    private String yaopinGongxiaoContent;


    /**
     * 药品禁忌
     */

    @TableField(value = "yaopin_jinji_content")
    private String yaopinJinjiContent;


    /**
     * 注意事项
     */

    @TableField(value = "yaopin_zhuyi_content")
    private String yaopinZhuyiContent;


    /**
     * 药品详情
     */

    @TableField(value = "yaopin_content")
    private String yaopinContent;


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
	 * 设置：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }


    /**
	 * 获取：药品名称
	 */

    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 设置：药品编号
	 */
    public String getYaopinUuidNumber() {
        return yaopinUuidNumber;
    }


    /**
	 * 获取：药品编号
	 */

    public void setYaopinUuidNumber(String yaopinUuidNumber) {
        this.yaopinUuidNumber = yaopinUuidNumber;
    }
    /**
	 * 设置：药品照片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }


    /**
	 * 获取：药品照片
	 */

    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
    }
    /**
	 * 设置：生产厂家
	 */
    public String getShengchanchangjia() {
        return shengchanchangjia;
    }


    /**
	 * 获取：生产厂家
	 */

    public void setShengchanchangjia(String shengchanchangjia) {
        this.shengchanchangjia = shengchanchangjia;
    }
    /**
	 * 设置：药品类型
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }


    /**
	 * 获取：药品类型
	 */

    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 设置：药品库存
	 */
    public Integer getYaopinKucunNumber() {
        return yaopinKucunNumber;
    }


    /**
	 * 获取：药品库存
	 */

    public void setYaopinKucunNumber(Integer yaopinKucunNumber) {
        this.yaopinKucunNumber = yaopinKucunNumber;
    }
    /**
	 * 设置：药品进价
	 */
    public Double getYaopinJinjiaMoney() {
        return yaopinJinjiaMoney;
    }


    /**
	 * 获取：药品进价
	 */

    public void setYaopinJinjiaMoney(Double yaopinJinjiaMoney) {
        this.yaopinJinjiaMoney = yaopinJinjiaMoney;
    }
    /**
	 * 设置：售价
	 */
    public Double getYaopinNewMoney() {
        return yaopinNewMoney;
    }


    /**
	 * 获取：售价
	 */

    public void setYaopinNewMoney(Double yaopinNewMoney) {
        this.yaopinNewMoney = yaopinNewMoney;
    }
    /**
	 * 设置：药品功效
	 */
    public String getYaopinGongxiaoContent() {
        return yaopinGongxiaoContent;
    }


    /**
	 * 获取：药品功效
	 */

    public void setYaopinGongxiaoContent(String yaopinGongxiaoContent) {
        this.yaopinGongxiaoContent = yaopinGongxiaoContent;
    }
    /**
	 * 设置：药品禁忌
	 */
    public String getYaopinJinjiContent() {
        return yaopinJinjiContent;
    }


    /**
	 * 获取：药品禁忌
	 */

    public void setYaopinJinjiContent(String yaopinJinjiContent) {
        this.yaopinJinjiContent = yaopinJinjiContent;
    }
    /**
	 * 设置：注意事项
	 */
    public String getYaopinZhuyiContent() {
        return yaopinZhuyiContent;
    }


    /**
	 * 获取：注意事项
	 */

    public void setYaopinZhuyiContent(String yaopinZhuyiContent) {
        this.yaopinZhuyiContent = yaopinZhuyiContent;
    }
    /**
	 * 设置：药品详情
	 */
    public String getYaopinContent() {
        return yaopinContent;
    }


    /**
	 * 获取：药品详情
	 */

    public void setYaopinContent(String yaopinContent) {
        this.yaopinContent = yaopinContent;
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
