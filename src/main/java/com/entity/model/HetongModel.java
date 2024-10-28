package com.entity.model;

import com.entity.HetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 合同模块
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class HetongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 合同名称
     */
    private String htname;


    /**
     * 签订客户
     */
    private Integer kehuId;


    /**
     * 合同文件
     */
    private String httongFile;


    /**
     * 合同详情
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
	 * 获取：合同名称
	 */
    public String getHtname() {
        return htname;
    }


    /**
	 * 设置：合同名称
	 */
    public void setHtname(String htname) {
        this.htname = htname;
    }
    /**
	 * 获取：签订客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：签订客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：合同文件
	 */
    public String getHttongFile() {
        return httongFile;
    }


    /**
	 * 设置：合同文件
	 */
    public void setHttongFile(String httongFile) {
        this.httongFile = httongFile;
    }
    /**
	 * 获取：合同详情
	 */
    public String getNeirongContent() {
        return neirongContent;
    }


    /**
	 * 设置：合同详情
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
