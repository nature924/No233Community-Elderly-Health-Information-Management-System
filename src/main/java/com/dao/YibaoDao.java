package com.dao;

import com.entity.YibaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YibaoView;

/**
 * 医保信息 Dao 接口
 *
 * @author 
 */
public interface YibaoDao extends BaseMapper<YibaoEntity> {

   List<YibaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
