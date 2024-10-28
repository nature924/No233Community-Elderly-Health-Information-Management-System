package com.dao;

import com.entity.YaopinshiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YaopinshiyongView;

/**
 * 药品使用 Dao 接口
 *
 * @author 
 */
public interface YaopinshiyongDao extends BaseMapper<YaopinshiyongEntity> {

   List<YaopinshiyongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
