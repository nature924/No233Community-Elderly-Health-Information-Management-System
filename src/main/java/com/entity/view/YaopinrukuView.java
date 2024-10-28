package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YaopinrukuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 药品入库
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yaopinruku")
public class YaopinrukuView extends YaopinrukuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 药品
		/**
		* 药品名称
		*/

		@ColumnInfo(comment="药品名称",type="varchar(200)")
		private String yaopinName;
		/**
		* 药品编号
		*/

		@ColumnInfo(comment="药品编号",type="varchar(200)")
		private String yaopinUuidNumber;
		/**
		* 药品照片
		*/

		@ColumnInfo(comment="药品照片",type="varchar(200)")
		private String yaopinPhoto;
		/**
		* 生产厂家
		*/

		@ColumnInfo(comment="生产厂家",type="varchar(200)")
		private String shengchanchangjia;
		/**
		* 药品类型
		*/
		@ColumnInfo(comment="药品类型",type="int(11)")
		private Integer yaopinTypes;
			/**
			* 药品类型的值
			*/
			@ColumnInfo(comment="药品类型的字典表值",type="varchar(200)")
			private String yaopinValue;
		/**
		* 药品库存
		*/

		@ColumnInfo(comment="药品库存",type="int(11)")
		private Integer yaopinKucunNumber;
		/**
		* 药品进价
		*/
		@ColumnInfo(comment="药品进价",type="decimal(10,2)")
		private Double yaopinJinjiaMoney;
		/**
		* 售价
		*/
		@ColumnInfo(comment="售价",type="decimal(10,2)")
		private Double yaopinNewMoney;
		/**
		* 药品功效
		*/

		@ColumnInfo(comment="药品功效",type="text")
		private String yaopinGongxiaoContent;
		/**
		* 药品禁忌
		*/

		@ColumnInfo(comment="药品禁忌",type="text")
		private String yaopinJinjiContent;
		/**
		* 注意事项
		*/

		@ColumnInfo(comment="注意事项",type="text")
		private String yaopinZhuyiContent;
		/**
		* 药品详情
		*/

		@ColumnInfo(comment="药品详情",type="text")
		private String yaopinContent;



	public YaopinrukuView() {

	}

	public YaopinrukuView(YaopinrukuEntity yaopinrukuEntity) {
		try {
			BeanUtils.copyProperties(this, yaopinrukuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 药品

		/**
		* 获取： 药品名称
		*/
		public String getYaopinName() {
			return yaopinName;
		}
		/**
		* 设置： 药品名称
		*/
		public void setYaopinName(String yaopinName) {
			this.yaopinName = yaopinName;
		}

		/**
		* 获取： 药品编号
		*/
		public String getYaopinUuidNumber() {
			return yaopinUuidNumber;
		}
		/**
		* 设置： 药品编号
		*/
		public void setYaopinUuidNumber(String yaopinUuidNumber) {
			this.yaopinUuidNumber = yaopinUuidNumber;
		}

		/**
		* 获取： 药品照片
		*/
		public String getYaopinPhoto() {
			return yaopinPhoto;
		}
		/**
		* 设置： 药品照片
		*/
		public void setYaopinPhoto(String yaopinPhoto) {
			this.yaopinPhoto = yaopinPhoto;
		}

		/**
		* 获取： 生产厂家
		*/
		public String getShengchanchangjia() {
			return shengchanchangjia;
		}
		/**
		* 设置： 生产厂家
		*/
		public void setShengchanchangjia(String shengchanchangjia) {
			this.shengchanchangjia = shengchanchangjia;
		}
		/**
		* 获取： 药品类型
		*/
		public Integer getYaopinTypes() {
			return yaopinTypes;
		}
		/**
		* 设置： 药品类型
		*/
		public void setYaopinTypes(Integer yaopinTypes) {
			this.yaopinTypes = yaopinTypes;
		}


			/**
			* 获取： 药品类型的值
			*/
			public String getYaopinValue() {
				return yaopinValue;
			}
			/**
			* 设置： 药品类型的值
			*/
			public void setYaopinValue(String yaopinValue) {
				this.yaopinValue = yaopinValue;
			}

		/**
		* 获取： 药品库存
		*/
		public Integer getYaopinKucunNumber() {
			return yaopinKucunNumber;
		}
		/**
		* 设置： 药品库存
		*/
		public void setYaopinKucunNumber(Integer yaopinKucunNumber) {
			this.yaopinKucunNumber = yaopinKucunNumber;
		}

		/**
		* 获取： 药品进价
		*/
		public Double getYaopinJinjiaMoney() {
			return yaopinJinjiaMoney;
		}
		/**
		* 设置： 药品进价
		*/
		public void setYaopinJinjiaMoney(Double yaopinJinjiaMoney) {
			this.yaopinJinjiaMoney = yaopinJinjiaMoney;
		}

		/**
		* 获取： 售价
		*/
		public Double getYaopinNewMoney() {
			return yaopinNewMoney;
		}
		/**
		* 设置： 售价
		*/
		public void setYaopinNewMoney(Double yaopinNewMoney) {
			this.yaopinNewMoney = yaopinNewMoney;
		}

		/**
		* 获取： 药品功效
		*/
		public String getYaopinGongxiaoContent() {
			return yaopinGongxiaoContent;
		}
		/**
		* 设置： 药品功效
		*/
		public void setYaopinGongxiaoContent(String yaopinGongxiaoContent) {
			this.yaopinGongxiaoContent = yaopinGongxiaoContent;
		}

		/**
		* 获取： 药品禁忌
		*/
		public String getYaopinJinjiContent() {
			return yaopinJinjiContent;
		}
		/**
		* 设置： 药品禁忌
		*/
		public void setYaopinJinjiContent(String yaopinJinjiContent) {
			this.yaopinJinjiContent = yaopinJinjiContent;
		}

		/**
		* 获取： 注意事项
		*/
		public String getYaopinZhuyiContent() {
			return yaopinZhuyiContent;
		}
		/**
		* 设置： 注意事项
		*/
		public void setYaopinZhuyiContent(String yaopinZhuyiContent) {
			this.yaopinZhuyiContent = yaopinZhuyiContent;
		}

		/**
		* 获取： 药品详情
		*/
		public String getYaopinContent() {
			return yaopinContent;
		}
		/**
		* 设置： 药品详情
		*/
		public void setYaopinContent(String yaopinContent) {
			this.yaopinContent = yaopinContent;
		}


	@Override
	public String toString() {
		return "YaopinrukuView{" +
			", yaopinName=" + yaopinName +
			", yaopinUuidNumber=" + yaopinUuidNumber +
			", yaopinPhoto=" + yaopinPhoto +
			", shengchanchangjia=" + shengchanchangjia +
			", yaopinKucunNumber=" + yaopinKucunNumber +
			", yaopinJinjiaMoney=" + yaopinJinjiaMoney +
			", yaopinNewMoney=" + yaopinNewMoney +
			", yaopinGongxiaoContent=" + yaopinGongxiaoContent +
			", yaopinJinjiContent=" + yaopinJinjiContent +
			", yaopinZhuyiContent=" + yaopinZhuyiContent +
			", yaopinContent=" + yaopinContent +
			"} " + super.toString();
	}
}
