package com.dao;

import com.entity.YaopinrukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YaopinrukuView;

/**
 * 药品入库 Dao 接口
 *
 * @author 
 */
public interface YaopinrukuDao extends BaseMapper<YaopinrukuEntity> {

   List<YaopinrukuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
