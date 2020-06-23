package com.service;

import java.util.List;

import com.bean.Orders;

public interface OrdersService {

	Orders getOrdersById(Integer oid);

	List<Orders> getgetOrdersByUid(Integer uid);

	Orders newOrders(Orders orders);

	void paySuccess(Orders orders);

	int confirm(Integer oId);

	List<Orders> getAllOrders();

	Orders getOrdersStatu(Integer oid);

}
