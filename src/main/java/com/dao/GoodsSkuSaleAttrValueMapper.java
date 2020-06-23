package com.dao;

import com.bean.GoodsSkuSaleAttrValue;
import com.bean.GoodsSkuSaleAttrValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSkuSaleAttrValueMapper {
    long countByExample(GoodsSkuSaleAttrValueExample example);

    int deleteByExample(GoodsSkuSaleAttrValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSkuSaleAttrValue record);

    int insertSelective(GoodsSkuSaleAttrValue record);

    List<GoodsSkuSaleAttrValue> selectByExample(GoodsSkuSaleAttrValueExample example);

    GoodsSkuSaleAttrValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSkuSaleAttrValue record, @Param("example") GoodsSkuSaleAttrValueExample example);

    int updateByExample(@Param("record") GoodsSkuSaleAttrValue record, @Param("example") GoodsSkuSaleAttrValueExample example);

    int updateByPrimaryKeySelective(GoodsSkuSaleAttrValue record);

    int updateByPrimaryKey(GoodsSkuSaleAttrValue record);
}