
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
 * 医保信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yibao")
public class YibaoController {
    private static final Logger logger = LoggerFactory.getLogger(YibaoController.class);

    private static final String TABLE_NAME = "yibao";

    @Autowired
    private YibaoService yibaoService;


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
    private YaopinshiyongService yaopinshiyongService;//药品使用
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
        params.put("yibaoDeleteStart",1);params.put("yibaoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yibaoService.queryPage(params);

        //字典表数据转换
        List<YibaoView> list =(List<YibaoView>)page.getList();
        for(YibaoView c:list){
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
        YibaoEntity yibao = yibaoService.selectById(id);
        if(yibao !=null){
            //entity转view
            YibaoView view = new YibaoView();
            BeanUtils.copyProperties( yibao , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yibao.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "yishengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 医生
            //级联表
            YishengEntity yisheng = yishengService.selectById(yibao.getYishengId());
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
    public R save(@RequestBody YibaoEntity yibao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yibao:{}",this.getClass().getName(),yibao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yibao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("医生".equals(role))
            yibao.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YibaoEntity> queryWrapper = new EntityWrapper<YibaoEntity>()
            .eq("yonghu_id", yibao.getYonghuId())
            .eq("yisheng_id", yibao.getYishengId())
            .eq("yibao_name", yibao.getYibaoName())
            .eq("yibao_types", yibao.getYibaoTypes())
            .eq("yibao_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YibaoEntity yibaoEntity = yibaoService.selectOne(queryWrapper);
        if(yibaoEntity==null){
            yibao.setYibaoDelete(1);
            yibao.setInsertTime(new Date());
            yibao.setCreateTime(new Date());
            yibaoService.insert(yibao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YibaoEntity yibao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yibao:{}",this.getClass().getName(),yibao.toString());
        YibaoEntity oldYibaoEntity = yibaoService.selectById(yibao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yibao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("医生".equals(role))
//            yibao.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(yibao.getYibaoPhoto()) || "null".equals(yibao.getYibaoPhoto())){
                yibao.setYibaoPhoto(null);
        }

            yibaoService.updateById(yibao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YibaoEntity> oldYibaoList =yibaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YibaoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YibaoEntity yibaoEntity = new YibaoEntity();
            yibaoEntity.setId(id);
            yibaoEntity.setYibaoDelete(2);
            list.add(yibaoEntity);
        }
        if(list != null && list.size() >0){
            yibaoService.updateBatchById(list);
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
            List<YibaoEntity> yibaoList = new ArrayList<>();//上传的东西
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
                            YibaoEntity yibaoEntity = new YibaoEntity();
//                            yibaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yibaoEntity.setYishengId(Integer.valueOf(data.get(0)));   //医生 要改的
//                            yibaoEntity.setYibaoName(data.get(0));                    //医保信息名称 要改的
//                            yibaoEntity.setYibaoTypes(Integer.valueOf(data.get(0)));   //医保类型 要改的
//                            yibaoEntity.setYibaoUuidNumber(data.get(0));                    //医保信息编号 要改的
//                            yibaoEntity.setYibaoPhoto("");//详情和图片
//                            yibaoEntity.setYibaoContent("");//详情和图片
//                            yibaoEntity.setYibaoDelete(1);//逻辑删除字段
//                            yibaoEntity.setInsertTime(date);//时间
//                            yibaoEntity.setCreateTime(date);//时间
                            yibaoList.add(yibaoEntity);


                            //把要查询是否重复的字段放入map中
                                //医保信息编号
                                if(seachFields.containsKey("yibaoUuidNumber")){
                                    List<String> yibaoUuidNumber = seachFields.get("yibaoUuidNumber");
                                    yibaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yibaoUuidNumber = new ArrayList<>();
                                    yibaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yibaoUuidNumber",yibaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //医保信息编号
                        List<YibaoEntity> yibaoEntities_yibaoUuidNumber = yibaoService.selectList(new EntityWrapper<YibaoEntity>().in("yibao_uuid_number", seachFields.get("yibaoUuidNumber")).eq("yibao_delete", 1));
                        if(yibaoEntities_yibaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YibaoEntity s:yibaoEntities_yibaoUuidNumber){
                                repeatFields.add(s.getYibaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [医保信息编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yibaoService.insertBatch(yibaoList);
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
        PageUtils page = yibaoService.queryPage(params);

        //字典表数据转换
        List<YibaoView> list =(List<YibaoView>)page.getList();
        for(YibaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YibaoEntity yibao = yibaoService.selectById(id);
            if(yibao !=null){


                //entity转view
                YibaoView view = new YibaoView();
                BeanUtils.copyProperties( yibao , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yibao.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YishengEntity yisheng = yishengService.selectById(yibao.getYishengId());
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
    public R add(@RequestBody YibaoEntity yibao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yibao:{}",this.getClass().getName(),yibao.toString());
        Wrapper<YibaoEntity> queryWrapper = new EntityWrapper<YibaoEntity>()
            .eq("yonghu_id", yibao.getYonghuId())
            .eq("yisheng_id", yibao.getYishengId())
            .eq("yibao_name", yibao.getYibaoName())
            .eq("yibao_types", yibao.getYibaoTypes())
            .eq("yibao_uuid_number", yibao.getYibaoUuidNumber())
            .eq("yibao_delete", yibao.getYibaoDelete())
//            .notIn("yibao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YibaoEntity yibaoEntity = yibaoService.selectOne(queryWrapper);
        if(yibaoEntity==null){
            yibao.setYibaoDelete(1);
            yibao.setInsertTime(new Date());
            yibao.setCreateTime(new Date());
        yibaoService.insert(yibao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

