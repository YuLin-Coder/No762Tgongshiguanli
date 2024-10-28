package com.entity.model;

import com.entity.XiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目信息模块
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class XiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 项目启动书
     */
    private String qidongshuFile;


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
	 * 获取：项目名称
	 */
    public String getXmname() {
        return xmname;
    }


    /**
	 * 设置：项目名称
	 */
    public void setXmname(String xmname) {
        this.xmname = xmname;
    }
    /**
	 * 获取：进度报工
	 */
    public String getSchedule() {
        return schedule;
    }


    /**
	 * 设置：进度报工
	 */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    /**
	 * 获取：项目费用
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 设置：项目费用
	 */
    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 获取：是否验收
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }


    /**
	 * 设置：是否验收
	 */
    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 获取：项目启动书
	 */
    public String getQidongshuFile() {
        return qidongshuFile;
    }


    /**
	 * 设置：项目启动书
	 */
    public void setQidongshuFile(String qidongshuFile) {
        this.qidongshuFile = qidongshuFile;
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
