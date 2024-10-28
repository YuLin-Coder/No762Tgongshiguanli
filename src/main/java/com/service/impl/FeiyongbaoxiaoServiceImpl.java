package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.FeiyongbaoxiaoDao;
import com.entity.FeiyongbaoxiaoEntity;
import com.service.FeiyongbaoxiaoService;
import com.entity.view.FeiyongbaoxiaoView;

/**
 * 费用报销单 服务实现类
 * @author 
 * @since 2021-03-24
 */
@Service("feiyongbaoxiaoService")
@Transactional
public class FeiyongbaoxiaoServiceImpl extends ServiceImpl<FeiyongbaoxiaoDao, FeiyongbaoxiaoEntity> implements FeiyongbaoxiaoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FeiyongbaoxiaoView> page =new Query<FeiyongbaoxiaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
