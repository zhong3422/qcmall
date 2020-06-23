package com.dao;

import com.bean.GoodsSku;
import com.bean.GoodsSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSkuMapper {
    long countByExample(GoodsSkuExample example);

    int deleteByExample(GoodsSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSku record);

    int insertSelective(GoodsSku record);

    List<GoodsSku> selectByExample(GoodsSkuExample example);
    
    List<GoodsSku> selectWithDetailsByExample(GoodsSkuExample example);

    GoodsSku selectByPrimaryKey(Integer id);
    
    GoodsSku selectWithDetailsByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSku record, @Param("example") GoodsSkuExample example);

    int updateByExample(@Param("record") GoodsSku record, @Param("example") GoodsSkuExample example);

    int updateByPrimaryKeySelective(GoodsSku record);

    int updateByPrimaryKey(GoodsSku record);

	GoodsSku selectNewSku();
}