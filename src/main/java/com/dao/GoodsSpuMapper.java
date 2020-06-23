package com.dao;

import com.bean.GoodsSpu;
import com.bean.GoodsSpuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface GoodsSpuMapper {
    long countByExample(GoodsSpuExample example);

    int deleteByExample(GoodsSpuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSpu record);

    int insertSelective(GoodsSpu record);

    List<GoodsSpu> selectByExample(GoodsSpuExample example);

    GoodsSpu selectByPrimaryKey(Integer id);
    
    GoodsSpu selectNewSpu();
    
    GoodsSpu selectWithDetailsByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSpu record, @Param("example") GoodsSpuExample example);

    int updateByExample(@Param("record") GoodsSpu record, @Param("example") GoodsSpuExample example);

    int updateByPrimaryKeySelective(GoodsSpu record);

    int updateByPrimaryKey(GoodsSpu record);

	List<GoodsSpu> keywordsSearch(GoodsSpuExample example);
}