package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Orderitems;
import com.controller.OrdersItems;
import com.dao.OrderitemsMapper;
import com.service.OrdersitemsService;

@Service("ordersitemsService")
public class OrdersitemsServiceImpl implements OrdersitemsService{

	@Autowired
	private OrderitemsMapper orderitemsMapper;

	@Override
	public void addOrderitems(Orderitems orderitems) {
		// TODO Auto-generated method stub
		orderitemsMapper.insertSelective(orderitems);
	}

	@Override
	public boolean updateordersitems(Orderitems ordersItems) {
		// TODO Auto-generated method stub
		return orderitemsMapper.updateByPrimaryKeySelective(ordersItems)>0;
	}
	
	
	
}
