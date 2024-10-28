package com.entity.model;

import com.entity.YaopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 药品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YaopinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 药品名称
     */
    private String yaopinName;


    /**
     * 药品编号
     */
    private String yaopinUuidNumber;


    /**
     * 药品照片
     */
    private String yaopinPhoto;


    /**
     * 生产厂家
     */
    private String shengchanchangjia;


    /**
     * 药品类型
     */
    private Integer yaopinTypes;


    /**
     * 药品库存
     */
    private Integer yaopinKucunNumber;


    /**
     * 药品进价
     */
    private Double yaopinJinjiaMoney;


    /**
     * 售价
     */
    private Double yaopinNewMoney;


    /**
     * 药品功效
     */
    private String yaopinGongxiaoContent;


    /**
     * 药品禁忌
     */
    private String yaopinJinjiContent;


    /**
     * 注意事项
     */
    private String yaopinZhuyiContent;


    /**
     * 药品详情
     */
    private String yaopinContent;


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
	 * 获取：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }


    /**
	 * 设置：药品名称
	 */
    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 获取：药品编号
	 */
    public String getYaopinUuidNumber() {
        return yaopinUuidNumber;
    }


    /**
	 * 设置：药品编号
	 */
    public void setYaopinUuidNumber(String yaopinUuidNumber) {
        this.yaopinUuidNumber = yaopinUuidNumber;
    }
    /**
	 * 获取：药品照片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }


    /**
	 * 设置：药品照片
	 */
    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
    }
    /**
	 * 获取：生产厂家
	 */
    public String getShengchanchangjia() {
        return shengchanchangjia;
    }


    /**
	 * 设置：生产厂家
	 */
    public void setShengchanchangjia(String shengchanchangjia) {
        this.shengchanchangjia = shengchanchangjia;
    }
    /**
	 * 获取：药品类型
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }


    /**
	 * 设置：药品类型
	 */
    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 获取：药品库存
	 */
    public Integer getYaopinKucunNumber() {
        return yaopinKucunNumber;
    }


    /**
	 * 设置：药品库存
	 */
    public void setYaopinKucunNumber(Integer yaopinKucunNumber) {
        this.yaopinKucunNumber = yaopinKucunNumber;
    }
    /**
	 * 获取：药品进价
	 */
    public Double getYaopinJinjiaMoney() {
        return yaopinJinjiaMoney;
    }


    /**
	 * 设置：药品进价
	 */
    public void setYaopinJinjiaMoney(Double yaopinJinjiaMoney) {
        this.yaopinJinjiaMoney = yaopinJinjiaMoney;
    }
    /**
	 * 获取：售价
	 */
    public Double getYaopinNewMoney() {
        return yaopinNewMoney;
    }


    /**
	 * 设置：售价
	 */
    public void setYaopinNewMoney(Double yaopinNewMoney) {
        this.yaopinNewMoney = yaopinNewMoney;
    }
    /**
	 * 获取：药品功效
	 */
    public String getYaopinGongxiaoContent() {
        return yaopinGongxiaoContent;
    }


    /**
	 * 设置：药品功效
	 */
    public void setYaopinGongxiaoContent(String yaopinGongxiaoContent) {
        this.yaopinGongxiaoContent = yaopinGongxiaoContent;
    }
    /**
	 * 获取：药品禁忌
	 */
    public String getYaopinJinjiContent() {
        return yaopinJinjiContent;
    }


    /**
	 * 设置：药品禁忌
	 */
    public void setYaopinJinjiContent(String yaopinJinjiContent) {
        this.yaopinJinjiContent = yaopinJinjiContent;
    }
    /**
	 * 获取：注意事项
	 */
    public String getYaopinZhuyiContent() {
        return yaopinZhuyiContent;
    }


    /**
	 * 设置：注意事项
	 */
    public void setYaopinZhuyiContent(String yaopinZhuyiContent) {
        this.yaopinZhuyiContent = yaopinZhuyiContent;
    }
    /**
	 * 获取：药品详情
	 */
    public String getYaopinContent() {
        return yaopinContent;
    }


    /**
	 * 设置：药品详情
	 */
    public void setYaopinContent(String yaopinContent) {
        this.yaopinContent = yaopinContent;
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
