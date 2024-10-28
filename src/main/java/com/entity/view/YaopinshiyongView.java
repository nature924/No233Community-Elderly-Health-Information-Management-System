package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YaopinshiyongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 药品使用
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yaopinshiyong")
public class YaopinshiyongView extends YaopinshiyongEntity implements Serializable {
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
	//级联表 医生
		/**
		* 医生姓名
		*/

		@ColumnInfo(comment="医生姓名",type="varchar(200)")
		private String yishengName;
		/**
		* 医生手机号
		*/

		@ColumnInfo(comment="医生手机号",type="varchar(200)")
		private String yishengPhone;
		/**
		* 医生身份证号
		*/

		@ColumnInfo(comment="医生身份证号",type="varchar(200)")
		private String yishengIdNumber;
		/**
		* 医生头像
		*/

		@ColumnInfo(comment="医生头像",type="varchar(200)")
		private String yishengPhoto;
		/**
		* 医生邮箱
		*/

		@ColumnInfo(comment="医生邮箱",type="varchar(200)")
		private String yishengEmail;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public YaopinshiyongView() {

	}

	public YaopinshiyongView(YaopinshiyongEntity yaopinshiyongEntity) {
		try {
			BeanUtils.copyProperties(this, yaopinshiyongEntity);
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
	//级联表的get和set 医生

		/**
		* 获取： 医生姓名
		*/
		public String getYishengName() {
			return yishengName;
		}
		/**
		* 设置： 医生姓名
		*/
		public void setYishengName(String yishengName) {
			this.yishengName = yishengName;
		}

		/**
		* 获取： 医生手机号
		*/
		public String getYishengPhone() {
			return yishengPhone;
		}
		/**
		* 设置： 医生手机号
		*/
		public void setYishengPhone(String yishengPhone) {
			this.yishengPhone = yishengPhone;
		}

		/**
		* 获取： 医生身份证号
		*/
		public String getYishengIdNumber() {
			return yishengIdNumber;
		}
		/**
		* 设置： 医生身份证号
		*/
		public void setYishengIdNumber(String yishengIdNumber) {
			this.yishengIdNumber = yishengIdNumber;
		}

		/**
		* 获取： 医生头像
		*/
		public String getYishengPhoto() {
			return yishengPhoto;
		}
		/**
		* 设置： 医生头像
		*/
		public void setYishengPhoto(String yishengPhoto) {
			this.yishengPhoto = yishengPhoto;
		}

		/**
		* 获取： 医生邮箱
		*/
		public String getYishengEmail() {
			return yishengEmail;
		}
		/**
		* 设置： 医生邮箱
		*/
		public void setYishengEmail(String yishengEmail) {
			this.yishengEmail = yishengEmail;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "YaopinshiyongView{" +
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
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yishengName=" + yishengName +
			", yishengPhone=" + yishengPhone +
			", yishengIdNumber=" + yishengIdNumber +
			", yishengPhoto=" + yishengPhoto +
			", yishengEmail=" + yishengEmail +
			"} " + super.toString();
	}
}
