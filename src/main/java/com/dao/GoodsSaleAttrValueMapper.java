package com.dao;

import com.bean.GoodsSaleAttrValue;
import com.bean.GoodsSaleAttrValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSaleAttrValueMapper {
    long countByExample(GoodsSaleAttrValueExample example);

    int deleteByExample(GoodsSaleAttrValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSaleAttrValue record);

    int insertSelective(GoodsSaleAttrValue record);

    List<GoodsSaleAttrValue> selectByExample(GoodsSaleAttrValueExample example);

    GoodsSaleAttrValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSaleAttrValue record, @Param("example") GoodsSaleAttrValueExample example);

    int updateByExample(@Param("record") GoodsSaleAttrValue record, @Param("example") GoodsSaleAttrValueExample example);

    int updateByPrimaryKeySelective(GoodsSaleAttrValue record);

    int updateByPrimaryKey(GoodsSaleAttrValue record);
}