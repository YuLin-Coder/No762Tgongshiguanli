package com.entity.vo;

import com.entity.HetongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 合同模块
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("hetong")
public class HetongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 合同名称
     */

    @TableField(value = "htname")
    private String htname;


    /**
     * 签订客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 合同文件
     */

    @TableField(value = "httong_file")
    private String httongFile;


    /**
     * 合同详情
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
	 * 设置：合同名称
	 */
    public String getHtname() {
        return htname;
    }


    /**
	 * 获取：合同名称
	 */

    public void setHtname(String htname) {
        this.htname = htname;
    }
    /**
	 * 设置：签订客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：签订客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：合同文件
	 */
    public String getHttongFile() {
        return httongFile;
    }


    /**
	 * 获取：合同文件
	 */

    public void setHttongFile(String httongFile) {
        this.httongFile = httongFile;
    }
    /**
	 * 设置：合同详情
	 */
    public String getNeirongContent() {
        return neirongContent;
    }


    /**
	 * 获取：合同详情
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
