package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.FeiyongbaoxiaoEntity;

import com.service.FeiyongbaoxiaoService;
import com.entity.view.FeiyongbaoxiaoView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 费用报销单
 * 后端接口
 * @author
 * @email
 * @date 2021-03-24
*/
@RestController
@Controller
@RequestMapping("/feiyongbaoxiao")
public class FeiyongbaoxiaoController {
    private static final Logger logger = LoggerFactory.getLogger(FeiyongbaoxiaoController.class);

    @Autowired
    private FeiyongbaoxiaoService feiyongbaoxiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "员工".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = feiyongbaoxiaoService.queryPage(params);

        //字典表数据转换
        List<FeiyongbaoxiaoView> list =(List<FeiyongbaoxiaoView>)page.getList();
        for(FeiyongbaoxiaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeiyongbaoxiaoEntity feiyongbaoxiao = feiyongbaoxiaoService.selectById(id);
        if(feiyongbaoxiao !=null){
            //entity转view
            FeiyongbaoxiaoView view = new FeiyongbaoxiaoView();
            BeanUtils.copyProperties( feiyongbaoxiao , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(feiyongbaoxiao.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FeiyongbaoxiaoEntity feiyongbaoxiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,feiyongbaoxiao:{}",this.getClass().getName(),feiyongbaoxiao.toString());
        Wrapper<FeiyongbaoxiaoEntity> queryWrapper = new EntityWrapper<FeiyongbaoxiaoEntity>()
            .eq("bxname", feiyongbaoxiao.getBxname())
            .eq("yonghu_id", feiyongbaoxiao.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeiyongbaoxiaoEntity feiyongbaoxiaoEntity = feiyongbaoxiaoService.selectOne(queryWrapper);
        if(feiyongbaoxiaoEntity==null){
            feiyongbaoxiao.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      feiyongbaoxiao.set
        //  }
            feiyongbaoxiaoService.insert(feiyongbaoxiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FeiyongbaoxiaoEntity feiyongbaoxiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,feiyongbaoxiao:{}",this.getClass().getName(),feiyongbaoxiao.toString());
        //根据字段查询是否有相同数据
        Wrapper<FeiyongbaoxiaoEntity> queryWrapper = new EntityWrapper<FeiyongbaoxiaoEntity>()
            .notIn("id",feiyongbaoxiao.getId())
            .andNew()
            .eq("bxname", feiyongbaoxiao.getBxname())
            .eq("yonghu_id", feiyongbaoxiao.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeiyongbaoxiaoEntity feiyongbaoxiaoEntity = feiyongbaoxiaoService.selectOne(queryWrapper);
        if(feiyongbaoxiaoEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      feiyongbaoxiao.set
            //  }
            feiyongbaoxiaoService.updateById(feiyongbaoxiao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        feiyongbaoxiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

