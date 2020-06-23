package com.dao;

import com.bean.SaleAttr;
import com.bean.SaleAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleAttrMapper {
    long countByExample(SaleAttrExample example);

    int deleteByExample(SaleAttrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleAttr record);

    int insertSelective(SaleAttr record);

    List<SaleAttr> selectByExample(SaleAttrExample example);

    SaleAttr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleAttr record, @Param("example") SaleAttrExample example);

    int updateByExample(@Param("record") SaleAttr record, @Param("example") SaleAttrExample example);

    int updateByPrimaryKeySelective(SaleAttr record);

    int updateByPrimaryKey(SaleAttr record);
}