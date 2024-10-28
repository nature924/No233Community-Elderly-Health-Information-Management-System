
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
 * 药品使用
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yaopinshiyong")
public class YaopinshiyongController {
    private static final Logger logger = LoggerFactory.getLogger(YaopinshiyongController.class);

    private static final String TABLE_NAME = "yaopinshiyong";

    @Autowired
    private YaopinshiyongService yaopinshiyongService;


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
    private YaopinrukuService yaopinrukuService;//药品入库
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
        PageUtils page = yaopinshiyongService.queryPage(params);

        //字典表数据转换
        List<YaopinshiyongView> list =(List<YaopinshiyongView>)page.getList();
        for(YaopinshiyongView c:list){
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
        YaopinshiyongEntity yaopinshiyong = yaopinshiyongService.selectById(id);
        if(yaopinshiyong !=null){
            //entity转view
            YaopinshiyongView view = new YaopinshiyongView();
            BeanUtils.copyProperties( yaopinshiyong , view );//把实体数据重构到view中
            //级联表 药品
            //级联表
            YaopinEntity yaopin = yaopinService.selectById(yaopinshiyong.getYaopinId());
            if(yaopin != null){
            BeanUtils.copyProperties( yaopin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yishengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYaopinId(yaopin.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yaopinshiyong.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yishengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 医生
            //级联表
            YishengEntity yisheng = yishengService.selectById(yaopinshiyong.getYishengId());
            if(yisheng != null){
            BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yishengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYishengId(yisheng.getId());
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
    public R save(@RequestBody YaopinshiyongEntity yaopinshiyong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yaopinshiyong:{}",this.getClass().getName(),yaopinshiyong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yaopinshiyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("医生".equals(role))
            yaopinshiyong.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YaopinshiyongEntity> queryWrapper = new EntityWrapper<YaopinshiyongEntity>()
            .eq("yaopin_id", yaopinshiyong.getYaopinId())
            .eq("yonghu_id", yaopinshiyong.getYonghuId())
            .eq("yisheng_id", yaopinshiyong.getYishengId())
            .eq("yaopinshiyong_number", yaopinshiyong.getYaopinshiyongNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinshiyongEntity yaopinshiyongEntity = yaopinshiyongService.selectOne(queryWrapper);
        if(yaopinshiyongEntity==null){
            yaopinshiyong.setInsertTime(new Date());
            yaopinshiyong.setCreateTime(new Date());
            yaopinshiyongService.insert(yaopinshiyong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YaopinshiyongEntity yaopinshiyong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yaopinshiyong:{}",this.getClass().getName(),yaopinshiyong.toString());
        YaopinshiyongEntity oldYaopinshiyongEntity = yaopinshiyongService.selectById(yaopinshiyong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yaopinshiyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("医生".equals(role))
//            yaopinshiyong.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            yaopinshiyongService.updateById(yaopinshiyong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YaopinshiyongEntity> oldYaopinshiyongList =yaopinshiyongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yaopinshiyongService.deleteBatchIds(Arrays.asList(ids));

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
            List<YaopinshiyongEntity> yaopinshiyongList = new ArrayList<>();//上传的东西
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
                            YaopinshiyongEntity yaopinshiyongEntity = new YaopinshiyongEntity();
//                            yaopinshiyongEntity.setYaopinId(Integer.valueOf(data.get(0)));   //药品 要改的
//                            yaopinshiyongEntity.setYonghuId(Integer.valueOf(data.get(0)));   //病人 要改的
//                            yaopinshiyongEntity.setYishengId(Integer.valueOf(data.get(0)));   //医生 要改的
//                            yaopinshiyongEntity.setYaopinshiyongUuidNumber(data.get(0));                    //药品使用编号 要改的
//                            yaopinshiyongEntity.setYaopinshiyongNumber(Integer.valueOf(data.get(0)));   //使用数量 要改的
//                            yaopinshiyongEntity.setCaozuoTime(sdf.parse(data.get(0)));          //使用时间 要改的
//                            yaopinshiyongEntity.setYaopinshiyongContent("");//详情和图片
//                            yaopinshiyongEntity.setInsertTime(date);//时间
//                            yaopinshiyongEntity.setCreateTime(date);//时间
                            yaopinshiyongList.add(yaopinshiyongEntity);


                            //把要查询是否重复的字段放入map中
                                //药品使用编号
                                if(seachFields.containsKey("yaopinshiyongUuidNumber")){
                                    List<String> yaopinshiyongUuidNumber = seachFields.get("yaopinshiyongUuidNumber");
                                    yaopinshiyongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yaopinshiyongUuidNumber = new ArrayList<>();
                                    yaopinshiyongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yaopinshiyongUuidNumber",yaopinshiyongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //药品使用编号
                        List<YaopinshiyongEntity> yaopinshiyongEntities_yaopinshiyongUuidNumber = yaopinshiyongService.selectList(new EntityWrapper<YaopinshiyongEntity>().in("yaopinshiyong_uuid_number", seachFields.get("yaopinshiyongUuidNumber")));
                        if(yaopinshiyongEntities_yaopinshiyongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YaopinshiyongEntity s:yaopinshiyongEntities_yaopinshiyongUuidNumber){
                                repeatFields.add(s.getYaopinshiyongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [药品使用编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yaopinshiyongService.insertBatch(yaopinshiyongList);
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
        PageUtils page = yaopinshiyongService.queryPage(params);

        //字典表数据转换
        List<YaopinshiyongView> list =(List<YaopinshiyongView>)page.getList();
        for(YaopinshiyongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YaopinshiyongEntity yaopinshiyong = yaopinshiyongService.selectById(id);
            if(yaopinshiyong !=null){


                //entity转view
                YaopinshiyongView view = new YaopinshiyongView();
                BeanUtils.copyProperties( yaopinshiyong , view );//把实体数据重构到view中

                //级联表
                    YaopinEntity yaopin = yaopinService.selectById(yaopinshiyong.getYaopinId());
                if(yaopin != null){
                    BeanUtils.copyProperties( yaopin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYaopinId(yaopin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yaopinshiyong.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YishengEntity yisheng = yishengService.selectById(yaopinshiyong.getYishengId());
                if(yisheng != null){
                    BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYishengId(yisheng.getId());
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
    public R add(@RequestBody YaopinshiyongEntity yaopinshiyong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yaopinshiyong:{}",this.getClass().getName(),yaopinshiyong.toString());
        Wrapper<YaopinshiyongEntity> queryWrapper = new EntityWrapper<YaopinshiyongEntity>()
            .eq("yaopin_id", yaopinshiyong.getYaopinId())
            .eq("yonghu_id", yaopinshiyong.getYonghuId())
            .eq("yisheng_id", yaopinshiyong.getYishengId())
            .eq("yaopinshiyong_uuid_number", yaopinshiyong.getYaopinshiyongUuidNumber())
            .eq("yaopinshiyong_number", yaopinshiyong.getYaopinshiyongNumber())
//            .notIn("yaopinshiyong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinshiyongEntity yaopinshiyongEntity = yaopinshiyongService.selectOne(queryWrapper);
        if(yaopinshiyongEntity==null){
            yaopinshiyong.setInsertTime(new Date());
            yaopinshiyong.setCreateTime(new Date());
        yaopinshiyongService.insert(yaopinshiyong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

