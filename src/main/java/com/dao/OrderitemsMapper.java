package com.dao;

import com.bean.Orderitems;
import com.bean.OrderitemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderitemsMapper {
    long countByExample(OrderitemsExample example);

    int deleteByExample(OrderitemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orderitems record);

    int insertSelective(Orderitems record);

    List<Orderitems> selectByExample(OrderitemsExample example);

    Orderitems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orderitems record, @Param("example") OrderitemsExample example);

    int updateByExample(@Param("record") Orderitems record, @Param("example") OrderitemsExample example);

    int updateByPrimaryKeySelective(Orderitems record);

    int updateByPrimaryKey(Orderitems record);
}