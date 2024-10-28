package com.dao;

import com.entity.JinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JinduView;

/**
 * 项目进度 Dao 接口
 *
 * @author 
 * @since 2021-03-24
 */
public interface JinduDao extends BaseMapper<JinduEntity> {

   List<JinduView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
