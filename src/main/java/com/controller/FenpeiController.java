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

import com.entity.FenpeiEntity;

import com.service.FenpeiService;
import com.entity.view.FenpeiView;
import com.service.RenwuService;
import com.entity.RenwuEntity;
import com.service.XiangmuService;
import com.entity.XiangmuEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 项目分配
 * 后端接口
 * @author
 * @email
 * @date 2021-03-24
*/
@RestController
@Controller
@RequestMapping("/fenpei")
public class FenpeiController {
    private static final Logger logger = LoggerFactory.getLogger(FenpeiController.class);

    @Autowired
    private FenpeiService fenpeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private RenwuService renwuService;
    @Autowired
    private XiangmuService xiangmuService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = fenpeiService.queryPage(params);

        //字典表数据转换
        List<FenpeiView> list =(List<FenpeiView>)page.getList();
        for(FenpeiView c:list){
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
        FenpeiEntity fenpei = fenpeiService.selectById(id);
        if(fenpei !=null){
            //entity转view
            FenpeiView view = new FenpeiView();
            BeanUtils.copyProperties( fenpei , view );//把实体数据重构到view中

            //级联表
            RenwuEntity renwu = renwuService.selectById(fenpei.getRenwuId());
            if(renwu != null){
                BeanUtils.copyProperties( renwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setRenwuId(renwu.getId());
            }
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(fenpei.getXiangmuId());
            if(xiangmu != null){
                BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setXiangmuId(xiangmu.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(fenpei.getYonghuId());
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
    public R save(@RequestBody FenpeiEntity fenpei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fenpei:{}",this.getClass().getName(),fenpei.toString());
        Wrapper<FenpeiEntity> queryWrapper = new EntityWrapper<FenpeiEntity>()
            .eq("xiangmu_id", fenpei.getXiangmuId())
            .eq("yonghu_id", fenpei.getYonghuId())
            .eq("renwu_id", fenpei.getRenwuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FenpeiEntity fenpeiEntity = fenpeiService.selectOne(queryWrapper);
        if(fenpeiEntity==null){
            fenpei.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      fenpei.set
        //  }
            fenpeiService.insert(fenpei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FenpeiEntity fenpei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fenpei:{}",this.getClass().getName(),fenpei.toString());
        //根据字段查询是否有相同数据
        Wrapper<FenpeiEntity> queryWrapper = new EntityWrapper<FenpeiEntity>()
            .notIn("id",fenpei.getId())
            .andNew()
            .eq("xiangmu_id", fenpei.getXiangmuId())
            .eq("yonghu_id", fenpei.getYonghuId())
            .eq("renwu_id", fenpei.getRenwuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FenpeiEntity fenpeiEntity = fenpeiService.selectOne(queryWrapper);
        if(fenpeiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fenpei.set
            //  }
            fenpeiService.updateById(fenpei);//根据id更新
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
        fenpeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

