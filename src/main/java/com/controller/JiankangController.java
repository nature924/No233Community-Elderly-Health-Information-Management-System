
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
 * 健康信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiankang")
public class JiankangController {
    private static final Logger logger = LoggerFactory.getLogger(JiankangController.class);

    private static final String TABLE_NAME = "jiankang";

    @Autowired
    private JiankangService jiankangService;


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
    private YaopinService yaopinService;//药品
    @Autowired
    private YaopinrukuService yaopinrukuService;//药品入库
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
        params.put("jiankangDeleteStart",1);params.put("jiankangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiankangService.queryPage(params);

        //字典表数据转换
        List<JiankangView> list =(List<JiankangView>)page.getList();
        for(JiankangView c:list){
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
        JiankangEntity jiankang = jiankangService.selectById(id);
        if(jiankang !=null){
            //entity转view
            JiankangView view = new JiankangView();
            BeanUtils.copyProperties( jiankang , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiankang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yishengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 医生
            //级联表
            YishengEntity yisheng = yishengService.selectById(jiankang.getYishengId());
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
    public R save(@RequestBody JiankangEntity jiankang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiankang:{}",this.getClass().getName(),jiankang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiankang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("医生".equals(role))
            jiankang.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiankangEntity> queryWrapper = new EntityWrapper<JiankangEntity>()
            .eq("yonghu_id", jiankang.getYonghuId())
            .eq("yisheng_id", jiankang.getYishengId())
            .eq("jiankang_name", jiankang.getJiankangName())
            .eq("jiankang_types", jiankang.getJiankangTypes())
            .eq("jiankang_zhibiao", jiankang.getJiankangZhibiao())
            .eq("jiankang_xueya", jiankang.getJiankangXueya())
            .eq("jiankang_xinlv", jiankang.getJiankangXinlv())
            .eq("jiankang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangEntity jiankangEntity = jiankangService.selectOne(queryWrapper);
        if(jiankangEntity==null){
            jiankang.setJiankangDelete(1);
            jiankang.setInsertTime(new Date());
            jiankang.setCreateTime(new Date());
            jiankangService.insert(jiankang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiankangEntity jiankang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiankang:{}",this.getClass().getName(),jiankang.toString());
        JiankangEntity oldJiankangEntity = jiankangService.selectById(jiankang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiankang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("医生".equals(role))
//            jiankang.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jiankang.getJiankangPhoto()) || "null".equals(jiankang.getJiankangPhoto())){
                jiankang.setJiankangPhoto(null);
        }

            jiankangService.updateById(jiankang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiankangEntity> oldJiankangList =jiankangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiankangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiankangEntity jiankangEntity = new JiankangEntity();
            jiankangEntity.setId(id);
            jiankangEntity.setJiankangDelete(2);
            list.add(jiankangEntity);
        }
        if(list != null && list.size() >0){
            jiankangService.updateBatchById(list);
        }

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
            List<JiankangEntity> jiankangList = new ArrayList<>();//上传的东西
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
                            JiankangEntity jiankangEntity = new JiankangEntity();
//                            jiankangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiankangEntity.setYishengId(Integer.valueOf(data.get(0)));   //医生 要改的
//                            jiankangEntity.setJiankangName(data.get(0));                    //健康信息名称 要改的
//                            jiankangEntity.setJiankangTypes(Integer.valueOf(data.get(0)));   //健康类型 要改的
//                            jiankangEntity.setJiankangZhibiao(data.get(0));                    //身体指标 要改的
//                            jiankangEntity.setJiankangXueya(Integer.valueOf(data.get(0)));   //血压 要改的
//                            jiankangEntity.setJiankangXinlv(Integer.valueOf(data.get(0)));   //心率 要改的
//                            jiankangEntity.setJiankangUuidNumber(data.get(0));                    //健康信息编号 要改的
//                            jiankangEntity.setJiankangPhoto("");//详情和图片
//                            jiankangEntity.setJiankangContent("");//详情和图片
//                            jiankangEntity.setJiankangDelete(1);//逻辑删除字段
//                            jiankangEntity.setInsertTime(date);//时间
//                            jiankangEntity.setCreateTime(date);//时间
                            jiankangList.add(jiankangEntity);


                            //把要查询是否重复的字段放入map中
                                //健康信息编号
                                if(seachFields.containsKey("jiankangUuidNumber")){
                                    List<String> jiankangUuidNumber = seachFields.get("jiankangUuidNumber");
                                    jiankangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiankangUuidNumber = new ArrayList<>();
                                    jiankangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiankangUuidNumber",jiankangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //健康信息编号
                        List<JiankangEntity> jiankangEntities_jiankangUuidNumber = jiankangService.selectList(new EntityWrapper<JiankangEntity>().in("jiankang_uuid_number", seachFields.get("jiankangUuidNumber")).eq("jiankang_delete", 1));
                        if(jiankangEntities_jiankangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiankangEntity s:jiankangEntities_jiankangUuidNumber){
                                repeatFields.add(s.getJiankangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [健康信息编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiankangService.insertBatch(jiankangList);
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
        PageUtils page = jiankangService.queryPage(params);

        //字典表数据转换
        List<JiankangView> list =(List<JiankangView>)page.getList();
        for(JiankangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankangEntity jiankang = jiankangService.selectById(id);
            if(jiankang !=null){


                //entity转view
                JiankangView view = new JiankangView();
                BeanUtils.copyProperties( jiankang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiankang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YishengEntity yisheng = yishengService.selectById(jiankang.getYishengId());
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
    public R add(@RequestBody JiankangEntity jiankang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiankang:{}",this.getClass().getName(),jiankang.toString());
        Wrapper<JiankangEntity> queryWrapper = new EntityWrapper<JiankangEntity>()
            .eq("yonghu_id", jiankang.getYonghuId())
            .eq("yisheng_id", jiankang.getYishengId())
            .eq("jiankang_name", jiankang.getJiankangName())
            .eq("jiankang_types", jiankang.getJiankangTypes())
            .eq("jiankang_zhibiao", jiankang.getJiankangZhibiao())
            .eq("jiankang_xueya", jiankang.getJiankangXueya())
            .eq("jiankang_xinlv", jiankang.getJiankangXinlv())
            .eq("jiankang_uuid_number", jiankang.getJiankangUuidNumber())
            .eq("jiankang_delete", jiankang.getJiankangDelete())
//            .notIn("jiankang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangEntity jiankangEntity = jiankangService.selectOne(queryWrapper);
        if(jiankangEntity==null){
            jiankang.setJiankangDelete(1);
            jiankang.setInsertTime(new Date());
            jiankang.setCreateTime(new Date());
        jiankangService.insert(jiankang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

