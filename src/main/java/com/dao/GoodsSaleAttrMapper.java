package com.dao;

import com.bean.GoodsSaleAttr;
import com.bean.GoodsSaleAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSaleAttrMapper {
    long countByExample(GoodsSaleAttrExample example);

    int deleteByExample(GoodsSaleAttrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSaleAttr record);

    int insertSelective(GoodsSaleAttr record);

    List<GoodsSaleAttr> selectByExample(GoodsSaleAttrExample example);

    GoodsSaleAttr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSaleAttr record, @Param("example") GoodsSaleAttrExample example);

    int updateByExample(@Param("record") GoodsSaleAttr record, @Param("example") GoodsSaleAttrExample example);

    int updateByPrimaryKeySelective(GoodsSaleAttr record);

    int updateByPrimaryKey(GoodsSaleAttr record);

	GoodsSaleAttr selectNewgoodsSaleAttr();
}