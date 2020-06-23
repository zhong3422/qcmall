package com.dao;

import com.bean.GoodsImages;
import com.bean.GoodsImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsImagesMapper {
    long countByExample(GoodsImagesExample example);

    int deleteByExample(GoodsImagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsImages record);

    int insertSelective(GoodsImages record);

    List<GoodsImages> selectByExample(GoodsImagesExample example);

    GoodsImages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsImages record, @Param("example") GoodsImagesExample example);

    int updateByExample(@Param("record") GoodsImages record, @Param("example") GoodsImagesExample example);

    int updateByPrimaryKeySelective(GoodsImages record);

    int updateByPrimaryKey(GoodsImages record);
}