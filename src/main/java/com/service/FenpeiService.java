package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FenpeiEntity;
import java.util.Map;

/**
 * 项目分配 服务类
 * @author 
 * @since 2021-03-24
 */
public interface FenpeiService extends IService<FenpeiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}