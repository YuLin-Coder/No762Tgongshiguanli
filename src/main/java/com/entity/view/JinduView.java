package com.entity.view;

import com.entity.JinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目进度
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("jindu")
public class JinduView extends JinduEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 xiangmu
			/**
			* 项目名称
			*/
			private String xmname;
			/**
			* 进度报工
			*/
			private String schedule;
			/**
			* 项目费用
			*/
			private Double expense;
			/**
			* 是否验收
			*/
			private Integer shifouTypes;
				/**
				* 是否验收的值
				*/
				private String shifouValue;
			/**
			* 项目启动书
			*/
			private String qidongshuFile;

		//级联表 yonghu
			/**
			* 名称
			*/
			private String name;
			/**
			* 账号
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 头像
			*/
			private String imgPhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 身份证
			*/
			private String idNumber;
			/**
			* 身份
			*/
			private String role;

	public JinduView() {

	}

	public JinduView(JinduEntity jinduEntity) {
		try {
			BeanUtils.copyProperties(this, jinduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




























				//级联表的get和set xiangmu
					/**
					* 获取： 项目名称
					*/
					public String getXmname() {
						return xmname;
					}
					/**
					* 设置： 项目名称
					*/
					public void setXmname(String xmname) {
						this.xmname = xmname;
					}
					/**
					* 获取： 进度报工
					*/
					public String getSchedule() {
						return schedule;
					}
					/**
					* 设置： 进度报工
					*/
					public void setSchedule(String schedule) {
						this.schedule = schedule;
					}
					/**
					* 获取： 项目费用
					*/
					public Double getExpense() {
						return expense;
					}
					/**
					* 设置： 项目费用
					*/
					public void setExpense(Double expense) {
						this.expense = expense;
					}
					/**
					* 获取： 是否验收
					*/
					public Integer getShifouTypes() {
						return shifouTypes;
					}
					/**
					* 设置： 是否验收
					*/
					public void setShifouTypes(Integer shifouTypes) {
						this.shifouTypes = shifouTypes;
					}


						/**
						* 获取： 是否验收的值
						*/
						public String getShifouValue() {
							return shifouValue;
						}
						/**
						* 设置： 是否验收的值
						*/
						public void setShifouValue(String shifouValue) {
							this.shifouValue = shifouValue;
						}
					/**
					* 获取： 项目启动书
					*/
					public String getQidongshuFile() {
						return qidongshuFile;
					}
					/**
					* 设置： 项目启动书
					*/
					public void setQidongshuFile(String qidongshuFile) {
						this.qidongshuFile = qidongshuFile;
					}




				//级联表的get和set yonghu
					/**
					* 获取： 名称
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 名称
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 账号
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账号
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 头像
					*/
					public String getImgPhoto() {
						return imgPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setImgPhoto(String imgPhoto) {
						this.imgPhoto = imgPhoto;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 身份证
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 身份
					*/
					public String getRole() {
						return role;
					}
					/**
					* 设置： 身份
					*/
					public void setRole(String role) {
						this.role = role;
					}



}
