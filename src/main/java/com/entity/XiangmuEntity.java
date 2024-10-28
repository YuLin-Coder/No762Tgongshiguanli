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
 * 项目信息模块
 *
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("xiangmu")
public class XiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuEntity() {

	}

	public XiangmuEntity(T t) {
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
     * 项目名称
     */
    @TableField(value = "xmname")

    private String xmname;


    /**
     * 进度报工
     */
    @TableField(value = "schedule")

    private String schedule;


    /**
     * 项目费用
     */
    @TableField(value = "expense")

    private Double expense;


    /**
     * 是否验收
     */
    @TableField(value = "shifou_types")

    private Integer shifouTypes;


    /**
     * 项目启动书
     */
    @TableField(value = "qidongshu_file")

    private String qidongshuFile;


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
	 * 设置：项目名称
	 */
    public String getXmname() {
        return xmname;
    }


    /**
	 * 获取：项目名称
	 */

    public void setXmname(String xmname) {
        this.xmname = xmname;
    }
    /**
	 * 设置：进度报工
	 */
    public String getSchedule() {
        return schedule;
    }


    /**
	 * 获取：进度报工
	 */

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    /**
	 * 设置：项目费用
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 获取：项目费用
	 */

    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 设置：是否验收
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }


    /**
	 * 获取：是否验收
	 */

    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 设置：项目启动书
	 */
    public String getQidongshuFile() {
        return qidongshuFile;
    }


    /**
	 * 获取：项目启动书
	 */

    public void setQidongshuFile(String qidongshuFile) {
        this.qidongshuFile = qidongshuFile;
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
        return "Xiangmu{" +
            "id=" + id +
            ", xmname=" + xmname +
            ", schedule=" + schedule +
            ", expense=" + expense +
            ", shifouTypes=" + shifouTypes +
            ", qidongshuFile=" + qidongshuFile +
            ", createTime=" + createTime +
        "}";
    }
}
