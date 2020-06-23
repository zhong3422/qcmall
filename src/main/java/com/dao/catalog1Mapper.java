package com.dao;

import com.bean.catalog1;
import com.bean.catalog1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface catalog1Mapper {
    long countByExample(catalog1Example example);

    int deleteByExample(catalog1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(catalog1 record);

    int insertSelective(catalog1 record);

    List<catalog1> selectByExample(catalog1Example example);

    catalog1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") catalog1 record, @Param("example") catalog1Example example);

    int updateByExample(@Param("record") catalog1 record, @Param("example") catalog1Example example);

    int updateByPrimaryKeySelective(catalog1 record);

    int updateByPrimaryKey(catalog1 record);
}