package com.dao;

import com.bean.catalog2;
import com.bean.catalog2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface catalog2Mapper {
    long countByExample(catalog2Example example);

    int deleteByExample(catalog2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(catalog2 record);

    int insertSelective(catalog2 record);

    List<catalog2> selectByExample(catalog2Example example);

    catalog2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") catalog2 record, @Param("example") catalog2Example example);

    int updateByExample(@Param("record") catalog2 record, @Param("example") catalog2Example example);

    int updateByPrimaryKeySelective(catalog2 record);

    int updateByPrimaryKey(catalog2 record);
}