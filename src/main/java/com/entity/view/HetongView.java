package com.entity.view;

import com.entity.HetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 合同模块
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("hetong")
public class HetongView extends HetongEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 kehu
			/**
			* 名称
			*/
			private String khname;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 头像
			*/
			private String imgPhoto;
			/**
			* 手机号
			*/
			private String khphone;
			/**
			* 所在公司
			*/
			private String gongshi;

	public HetongView() {

	}

	public HetongView(HetongEntity hetongEntity) {
		try {
			BeanUtils.copyProperties(this, hetongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set kehu
					/**
					* 获取： 名称
					*/
					public String getKhname() {
						return khname;
					}
					/**
					* 设置： 名称
					*/
					public void setKhname(String khname) {
						this.khname = khname;
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
					* 获取： 手机号
					*/
					public String getKhphone() {
						return khphone;
					}
					/**
					* 设置： 手机号
					*/
					public void setKhphone(String khphone) {
						this.khphone = khphone;
					}
					/**
					* 获取： 所在公司
					*/
					public String getGongshi() {
						return gongshi;
					}
					/**
					* 设置： 所在公司
					*/
					public void setGongshi(String gongshi) {
						this.gongshi = gongshi;
					}








}
