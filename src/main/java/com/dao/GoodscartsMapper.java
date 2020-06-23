package com.dao;

import com.bean.Goodscarts;
import com.bean.GoodscartsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodscartsMapper {
    long countByExample(GoodscartsExample example);

    int deleteByExample(GoodscartsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goodscarts record);

    int insertSelective(Goodscarts record);

    List<Goodscarts> selectByExample(GoodscartsExample example);
    
    List<Goodscarts> selectWithDetailsByExample(GoodscartsExample example);

    Goodscarts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goodscarts record, @Param("example") GoodscartsExample example);

    int updateByExample(@Param("record") Goodscarts record, @Param("example") GoodscartsExample example);

    int updateByPrimaryKeySelective(Goodscarts record);

    int updateByPrimaryKey(Goodscarts record);
}