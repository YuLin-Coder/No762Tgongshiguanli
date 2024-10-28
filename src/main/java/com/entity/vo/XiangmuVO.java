package com.entity.vo;

import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目信息模块
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("xiangmu")
public class XiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
