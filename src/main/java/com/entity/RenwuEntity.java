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
 * 任务
 *
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("renwu")
public class RenwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RenwuEntity() {

	}

	public RenwuEntity(T t) {
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
     * 任务名称
     */
    @TableField(value = "rwname")

    private String rwname;


    /**
     * 任务类型
     */
    @TableField(value = "rwleix_types")

    private Integer rwleixTypes;


    /**
     * 任务内容
     */
    @TableField(value = "neirong_content")

    private String neirongContent;


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
	 * 设置：任务名称
	 */
    public String getRwname() {
        return rwname;
    }


    /**
	 * 获取：任务名称
	 */

    public void setRwname(String rwname) {
        this.rwname = rwname;
    }
    /**
	 * 设置：任务类型
	 */
    public Integer getRwleixTypes() {
        return rwleixTypes;
    }


    /**
	 * 获取：任务类型
	 */

    public void setRwleixTypes(Integer rwleixTypes) {
        this.rwleixTypes = rwleixTypes;
    }
    /**
	 * 设置：任务内容
	 */
    public String getNeirongContent() {
        return neirongContent;
    }


    /**
	 * 获取：任务内容
	 */

    public void setNeirongContent(String neirongContent) {
        this.neirongContent = neirongContent;
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
        return "Renwu{" +
            "id=" + id +
            ", rwname=" + rwname +
            ", rwleixTypes=" + rwleixTypes +
            ", neirongContent=" + neirongContent +
            ", createTime=" + createTime +
        "}";
    }
}
