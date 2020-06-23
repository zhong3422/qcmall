package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Orderitems;
import com.service.OrdersitemsService;

@Controller
public class OrderItemsController {

	@Autowired
	private OrdersitemsService ordersitemsService;
	
	@RequestMapping("updateordersitems")
	@ResponseBody
	public boolean updateordersitems(Orderitems ordersItems) {
		System.out.println(ordersItems);
		return ordersitemsService.updateordersitems(ordersItems);
	}
	
	
}
