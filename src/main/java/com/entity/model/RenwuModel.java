package com.entity.model;

import com.entity.RenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class RenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 任务名称
     */
    private String rwname;


    /**
     * 任务类型
     */
    private Integer rwleixTypes;


    /**
     * 任务内容
     */
    private String neirongContent;


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
	 * 获取：任务名称
	 */
    public String getRwname() {
        return rwname;
    }


    /**
	 * 设置：任务名称
	 */
    public void setRwname(String rwname) {
        this.rwname = rwname;
    }
    /**
	 * 获取：任务类型
	 */
    public Integer getRwleixTypes() {
        return rwleixTypes;
    }


    /**
	 * 设置：任务类型
	 */
    public void setRwleixTypes(Integer rwleixTypes) {
        this.rwleixTypes = rwleixTypes;
    }
    /**
	 * 获取：任务内容
	 */
    public String getNeirongContent() {
        return neirongContent;
    }


    /**
	 * 设置：任务内容
	 */
    public void setNeirongContent(String neirongContent) {
        this.neirongContent = neirongContent;
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
