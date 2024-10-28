package com.entity.model;

import com.entity.KehuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客户模块
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class KehuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 名称
     */
    private String khname;


    /**
     * 性别
     */
    private Integer sexTypes;


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
	 * 获取：名称
	 */
    public String getKhname() {
        return khname;
    }


    /**
	 * 设置：名称
	 */
    public void setKhname(String khname) {
        this.khname = khname;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 获取：手机号
	 */
    public String getKhphone() {
        return khphone;
    }


    /**
	 * 设置：手机号
	 */
    public void setKhphone(String khphone) {
        this.khphone = khphone;
    }
    /**
	 * 获取：所在公司
	 */
    public String getGongshi() {
        return gongshi;
    }


    /**
	 * 设置：所在公司
	 */
    public void setGongshi(String gongshi) {
        this.gongshi = gongshi;
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
