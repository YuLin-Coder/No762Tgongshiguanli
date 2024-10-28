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

import com.entity.HetongEntity;

import com.service.HetongService;
import com.entity.view.HetongView;
import com.service.KehuService;
import com.entity.KehuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 合同模块
 * 后端接口
 * @author
 * @email
 * @date 2021-03-24
*/
@RestController
@Controller
@RequestMapping("/hetong")
public class HetongController {
    private static final Logger logger = LoggerFactory.getLogger(HetongController.class);

    @Autowired
    private HetongService hetongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private KehuService kehuService;


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
        PageUtils page = hetongService.queryPage(params);

        //字典表数据转换
        List<HetongView> list =(List<HetongView>)page.getList();
        for(HetongView c:list){
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
        HetongEntity hetong = hetongService.selectById(id);
        if(hetong !=null){
            //entity转view
            HetongView view = new HetongView();
            BeanUtils.copyProperties( hetong , view );//把实体数据重构到view中

            //级联表
            KehuEntity kehu = kehuService.selectById(hetong.getKehuId());
            if(kehu != null){
                BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKehuId(kehu.getId());
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
    public R save(@RequestBody HetongEntity hetong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hetong:{}",this.getClass().getName(),hetong.toString());
        Wrapper<HetongEntity> queryWrapper = new EntityWrapper<HetongEntity>()
            .eq("htname", hetong.getHtname())
            .eq("kehu_id", hetong.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongEntity hetongEntity = hetongService.selectOne(queryWrapper);
        if(hetongEntity==null){
            hetong.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      hetong.set
        //  }
            hetongService.insert(hetong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HetongEntity hetong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,hetong:{}",this.getClass().getName(),hetong.toString());
        //根据字段查询是否有相同数据
        Wrapper<HetongEntity> queryWrapper = new EntityWrapper<HetongEntity>()
            .notIn("id",hetong.getId())
            .andNew()
            .eq("htname", hetong.getHtname())
            .eq("kehu_id", hetong.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongEntity hetongEntity = hetongService.selectOne(queryWrapper);
        if("".equals(hetong.getHttongFile()) || "null".equals(hetong.getHttongFile())){
                hetong.setHttongFile(null);
        }
        if(hetongEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      hetong.set
            //  }
            hetongService.updateById(hetong);//根据id更新
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
        hetongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

