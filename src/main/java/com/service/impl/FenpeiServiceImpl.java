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

import com.dao.FenpeiDao;
import com.entity.FenpeiEntity;
import com.service.FenpeiService;
import com.entity.view.FenpeiView;

/**
 * 项目分配 服务实现类
 * @author 
 * @since 2021-03-24
 */
@Service("fenpeiService")
@Transactional
public class FenpeiServiceImpl extends ServiceImpl<FenpeiDao, FenpeiEntity> implements FenpeiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FenpeiView> page =new Query<FenpeiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
