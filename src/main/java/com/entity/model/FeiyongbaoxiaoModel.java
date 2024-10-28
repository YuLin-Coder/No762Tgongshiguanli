package com.entity.model;

import com.entity.FeiyongbaoxiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 费用报销单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class FeiyongbaoxiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 花费原因
     */
    private String bxname;


    /**
     * 花费人
     */
    private Integer yonghuId;


    /**
     * 花费金额
     */
    private Double expense;


    /**
     * 报销金额
     */
    private Double bxexpense;


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
	 * 获取：花费原因
	 */
    public String getBxname() {
        return bxname;
    }


    /**
	 * 设置：花费原因
	 */
    public void setBxname(String bxname) {
        this.bxname = bxname;
    }
    /**
	 * 获取：花费人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：花费人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：花费金额
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 设置：花费金额
	 */
    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 获取：报销金额
	 */
    public Double getBxexpense() {
        return bxexpense;
    }


    /**
	 * 设置：报销金额
	 */
    public void setBxexpense(Double bxexpense) {
        this.bxexpense = bxexpense;
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
