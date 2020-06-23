package com.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.OrderitemsExample.Criteria;
import com.bean.Orders;
import com.bean.OrdersExample;
import com.dao.OrdersMapper;
import com.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public Orders getOrdersById(Integer oid) {
		// TODO Auto-generated method stub
		return ordersMapper.selectWithDetailsByPrimaryKey(oid);
//		return null;
	}

	@Override
	public List<Orders> getgetOrdersByUid(Integer uid) {
		// TODO Auto-generated method stub
		OrdersExample ordersExample=new OrdersExample();
		ordersExample.createCriteria().andUIdEqualTo(uid);
		ordersExample.setOrderByClause("orders.id DESC");
		return ordersMapper.selectWithDetailsByExample(ordersExample);
//		return null;
	}

	@Override
	public Orders newOrders(Orders orders) {
		// TODO Auto-generated method stub
		ordersMapper.insertSelective(orders);
		System.out.println("新增的订单："+orders);
		
		return ordersMapper.getNewOrders();
//		return null;
	}

	@Override
	public void paySuccess(Orders orders) {
		// TODO Auto-generated method stub
		ordersMapper.updateByPrimaryKeySelective(orders);
	}

	@Override
	public int confirm(Integer oId) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public List<Orders> getAllOrders() {
//		// TODO Auto-generated method stub
//		return ordersMapper.selectWithDetailsByExample(null);
//	}

//	@Override
//	public int confirm(Integer oId) {
//		// TODO Auto-generated method stub
//		Orders orders=new Orders();
//		orders.setoId(oId);
//		orders.setoCompletiontime(new Date());
//		orders.setoStatu("已完成");
//		return ordersMapper.updateByPrimaryKeySelective(orders);
//	}
//
	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		OrdersExample ordersExample=new OrdersExample();
		ordersExample.setOrderByClause("orders.id DESC");
		return ordersMapper.selectByExample(ordersExample);
	}

	@Override
	public Orders getOrdersStatu(Integer oid) {
		// TODO Auto-generated method stub
		return ordersMapper.selectByPrimaryKey(oid);
	}

}
