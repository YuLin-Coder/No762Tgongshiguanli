package com.entity.vo;

import com.entity.RenwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 任务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("renwu")
public class RenwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
