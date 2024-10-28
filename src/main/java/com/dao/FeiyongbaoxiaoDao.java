package com.dao;

import com.entity.FeiyongbaoxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FeiyongbaoxiaoView;

/**
 * 费用报销单 Dao 接口
 *
 * @author 
 * @since 2021-03-24
 */
public interface FeiyongbaoxiaoDao extends BaseMapper<FeiyongbaoxiaoEntity> {

   List<FeiyongbaoxiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
