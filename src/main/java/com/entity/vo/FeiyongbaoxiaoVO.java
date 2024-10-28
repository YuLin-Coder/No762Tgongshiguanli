package com.entity.vo;

import com.entity.FeiyongbaoxiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 费用报销单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("feiyongbaoxiao")
public class FeiyongbaoxiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 花费原因
     */

    @TableField(value = "bxname")
    private String bxname;


    /**
     * 花费人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 花费金额
     */

    @TableField(value = "expense")
    private Double expense;


    /**
     * 报销金额
     */

    @TableField(value = "bxexpense")
    private Double bxexpense;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：花费原因
	 */
    public String getBxname() {
        return bxname;
    }


    /**
	 * 获取：花费原因
	 */

    public void setBxname(String bxname) {
        this.bxname = bxname;
    }
    /**
	 * 设置：花费人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：花费人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：花费金额
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 获取：花费金额
	 */

    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 设置：报销金额
	 */
    public Double getBxexpense() {
        return bxexpense;
    }


    /**
	 * 获取：报销金额
	 */

    public void setBxexpense(Double bxexpense) {
        this.bxexpense = bxexpense;
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

}
