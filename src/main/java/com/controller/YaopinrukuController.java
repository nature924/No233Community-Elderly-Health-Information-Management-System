
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
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
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 药品入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yaopinruku")
public class YaopinrukuController {
    private static final Logger logger = LoggerFactory.getLogger(YaopinrukuController.class);

    private static final String TABLE_NAME = "yaopinruku";

    @Autowired
    private YaopinrukuService yaopinrukuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BingliService bingliService;//就诊历史
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JiankangService jiankangService;//健康信息
    @Autowired
    private YaopinService yaopinService;//药品
    @Autowired
    private YaopinshiyongService yaopinshiyongService;//药品使用
    @Autowired
    private YibaoService yibaoService;//医保信息
    @Autowired
    private YishengService yishengService;//医生
    @Autowired
    private YishengYuyueService yishengYuyueService;//预约
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yaopinrukuService.queryPage(params);

        //字典表数据转换
        List<YaopinrukuView> list =(List<YaopinrukuView>)page.getList();
        for(YaopinrukuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YaopinrukuEntity yaopinruku = yaopinrukuService.selectById(id);
        if(yaopinruku !=null){
            //entity转view
            YaopinrukuView view = new YaopinrukuView();
            BeanUtils.copyProperties( yaopinruku , view );//把实体数据重构到view中
            //级联表 药品
            //级联表
            YaopinEntity yaopin = yaopinService.selectById(yaopinruku.getYaopinId());
            if(yaopin != null){
            BeanUtils.copyProperties( yaopin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYaopinId(yaopin.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YaopinrukuEntity yaopinruku, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yaopinruku:{}",this.getClass().getName(),yaopinruku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YaopinrukuEntity> queryWrapper = new EntityWrapper<YaopinrukuEntity>()
            .eq("yaopin_id", yaopinruku.getYaopinId())
            .eq("yaopinruku_number", yaopinruku.getYaopinrukuNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinrukuEntity yaopinrukuEntity = yaopinrukuService.selectOne(queryWrapper);
        if(yaopinrukuEntity==null){
            yaopinruku.setInsertTime(new Date());
            yaopinruku.setCreateTime(new Date());
            yaopinrukuService.insert(yaopinruku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YaopinrukuEntity yaopinruku, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yaopinruku:{}",this.getClass().getName(),yaopinruku.toString());
        YaopinrukuEntity oldYaopinrukuEntity = yaopinrukuService.selectById(yaopinruku.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            yaopinrukuService.updateById(yaopinruku);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YaopinrukuEntity> oldYaopinrukuList =yaopinrukuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yaopinrukuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YaopinrukuEntity> yaopinrukuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YaopinrukuEntity yaopinrukuEntity = new YaopinrukuEntity();
//                            yaopinrukuEntity.setYaopinId(Integer.valueOf(data.get(0)));   //药品 要改的
//                            yaopinrukuEntity.setYaopinrukuUuidNumber(data.get(0));                    //药品入库编号 要改的
//                            yaopinrukuEntity.setYaopinrukuNumber(Integer.valueOf(data.get(0)));   //入库数量 要改的
//                            yaopinrukuEntity.setCaozuoTime(sdf.parse(data.get(0)));          //入库时间 要改的
//                            yaopinrukuEntity.setYaopinrukuContent("");//详情和图片
//                            yaopinrukuEntity.setInsertTime(date);//时间
//                            yaopinrukuEntity.setCreateTime(date);//时间
                            yaopinrukuList.add(yaopinrukuEntity);


                            //把要查询是否重复的字段放入map中
                                //药品入库编号
                                if(seachFields.containsKey("yaopinrukuUuidNumber")){
                                    List<String> yaopinrukuUuidNumber = seachFields.get("yaopinrukuUuidNumber");
                                    yaopinrukuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yaopinrukuUuidNumber = new ArrayList<>();
                                    yaopinrukuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yaopinrukuUuidNumber",yaopinrukuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //药品入库编号
                        List<YaopinrukuEntity> yaopinrukuEntities_yaopinrukuUuidNumber = yaopinrukuService.selectList(new EntityWrapper<YaopinrukuEntity>().in("yaopinruku_uuid_number", seachFields.get("yaopinrukuUuidNumber")));
                        if(yaopinrukuEntities_yaopinrukuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YaopinrukuEntity s:yaopinrukuEntities_yaopinrukuUuidNumber){
                                repeatFields.add(s.getYaopinrukuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [药品入库编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yaopinrukuService.insertBatch(yaopinrukuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yaopinrukuService.queryPage(params);

        //字典表数据转换
        List<YaopinrukuView> list =(List<YaopinrukuView>)page.getList();
        for(YaopinrukuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YaopinrukuEntity yaopinruku = yaopinrukuService.selectById(id);
            if(yaopinruku !=null){


                //entity转view
                YaopinrukuView view = new YaopinrukuView();
                BeanUtils.copyProperties( yaopinruku , view );//把实体数据重构到view中

                //级联表
                    YaopinEntity yaopin = yaopinService.selectById(yaopinruku.getYaopinId());
                if(yaopin != null){
                    BeanUtils.copyProperties( yaopin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYaopinId(yaopin.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YaopinrukuEntity yaopinruku, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yaopinruku:{}",this.getClass().getName(),yaopinruku.toString());
        Wrapper<YaopinrukuEntity> queryWrapper = new EntityWrapper<YaopinrukuEntity>()
            .eq("yaopin_id", yaopinruku.getYaopinId())
            .eq("yaopinruku_uuid_number", yaopinruku.getYaopinrukuUuidNumber())
            .eq("yaopinruku_number", yaopinruku.getYaopinrukuNumber())
//            .notIn("yaopinruku_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinrukuEntity yaopinrukuEntity = yaopinrukuService.selectOne(queryWrapper);
        if(yaopinrukuEntity==null){
            yaopinruku.setInsertTime(new Date());
            yaopinruku.setCreateTime(new Date());
        yaopinrukuService.insert(yaopinruku);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

