package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 客户模块
 *
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("kehu")
public class KehuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuEntity() {

	}

	public KehuEntity(T t) {
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
    @TableField(value = "id")

    private Integer id;


    /**
     * 名称
     */
    @TableField(value = "khname")

    private String khname;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 头像
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 手机号
     */
    @TableField(value = "khphone")

    private String khphone;


    /**
     * 所在公司
     */
    @TableField(value = "gongshi")

    private String gongshi;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：名称
	 */
    public String getKhname() {
        return khname;
    }


    /**
	 * 获取：名称
	 */

    public void setKhname(String khname) {
        this.khname = khname;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：手机号
	 */
    public String getKhphone() {
        return khphone;
    }


    /**
	 * 获取：手机号
	 */

    public void setKhphone(String khphone) {
        this.khphone = khphone;
    }
    /**
	 * 设置：所在公司
	 */
    public String getGongshi() {
        return gongshi;
    }


    /**
	 * 获取：所在公司
	 */

    public void setGongshi(String gongshi) {
        this.gongshi = gongshi;
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

    @Override
    public String toString() {
        return "Kehu{" +
            "id=" + id +
            ", khname=" + khname +
            ", sexTypes=" + sexTypes +
            ", imgPhoto=" + imgPhoto +
            ", khphone=" + khphone +
            ", gongshi=" + gongshi +
            ", createTime=" + createTime +
        "}";
    }
}
