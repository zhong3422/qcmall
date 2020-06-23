package com.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Address;
import com.bean.GoodsSku;
import com.bean.Msg;
//import com.bean.Goods;
//import com.bean.Images;
import com.bean.Orderitems;
import com.bean.Orders;
import com.bean.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.service.GoodsService;
import com.service.GoodsSkuService;
import com.service.OrdersService;
import com.service.OrdersitemsService;
import com.until.TwoDimensionalCode;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
//	@Autowired
//	private GoodsService goodsService;
	@Autowired
	private OrdersitemsService ordersitemsService;
	@Autowired
	private GoodsSkuService goodsSkuService;
	
	@RequestMapping("getOrdersById")
	public String getOrdersById(@RequestParam Integer oid,Model model) {
		Orders orders=ordersService.getOrdersById(oid);
		System.out.println(orders);
		for (Orderitems orderitems : orders.getOrderitems()) {
			System.out.println(orderitems+orderitems.getGoodsSku().toString());
//			orderitems.getGoods().getImagesList()
//			for (Images images : orderitems.getGoods().getImagesList()) {
//				System.out.println(images);
//			}
		}
		model.addAttribute("orders", orders);
		return "orders/ordersDetails";
	}
	
	@RequestMapping("getOrderStatu")
	@ResponseBody
	public Orders getOrderStatu(@RequestParam Integer oid) {
		Orders orders=ordersService.getOrdersStatu(oid);
		System.out.println("获取了订单状态"+orders);
		return orders;
	}
	
//	
//	
	@RequestMapping("adminGetOrdersByIdEdit")
	public String admingetOrdersByIdEdit(@RequestParam Integer oid,Model model) {
		Orders orders=ordersService.getOrdersById(oid);
		System.out.println(orders);
//		for (Orderitems orderitems : orders.getOrderitems()) {
//			System.out.println(orderitems+orderitems.getGoods().toString());
////			orderitems.getGoods().getImagesList()
//			for (Images images : orderitems.getGoods().getImagesList()) {
//				System.out.println(images);
//			}
//		}
		model.addAttribute("orders", orders);
		return "admin/orderEdit";
	}
//	
	@RequestMapping("adminGetOrdersById")
	public String admingetOrdersById(@RequestParam Integer oid,Model model) {
		Orders orders=ordersService.getOrdersById(oid);
		System.out.println(orders);
//		for (Orderitems orderitems : orders.getOrderitems()) {
//			System.out.println(orderitems+orderitems.getGoods().toString());
////			orderitems.getGoods().getImagesList()
//			for (Images images : orderitems.getGoods().getImagesList()) {
//				System.out.println(images);
//			}
//		}
		model.addAttribute("orders", orders);
		return "admin/ordersDetails";
	}
//	
//	
//	@RequestMapping("getOrderDetails")
//	@ResponseBody
//	public Orders getOrdersDetails(@RequestParam Integer oid) {
//		Orders orders=ordersService.getOrdersById(oid);
//		System.out.println(orders);
//		for (Orderitems orderitems : orders.getOrderitems()) {
//			System.out.println(orderitems+orderitems.getGoods().toString());
////			orderitems.getGoods().getImagesList()
//			for (Images images : orderitems.getGoods().getImagesList()) {
//				System.out.println(images);
//			}
//		}
//		
//		return orders;
//	}
//	
//	@RequestMapping("getOrders")
//	public String getOrders(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,Model model,HttpServletRequest request ) {
//		PageHelper.startPage(pageNumber, 8);
//		Users users=(Users) request.getSession().getAttribute("users");
//		List<Orders> list=ordersService.getgetOrdersByUid(users.getuId());
//		PageInfo<Orders> pageInfo=new PageInfo<Orders>(list, 5);
//		model.addAttribute("pageInfo", pageInfo);
//		for (Orders orders : list) {
//			System.out.println(orders);
//			for (Orderitems orderitems : orders.getOrderitems()) {
//				System.out.println(orderitems);
//			}
//		}
//		return "orders/ordersList";
//	}
	
	@RequestMapping("neworders")
	@ResponseBody
	public Msg newOrders(Integer[] gid,Integer[] number,BigDecimal[] price,String address,HttpServletRequest request,HttpServletResponse response) {
		Orders orders=new Orders();
		Users users=(Users) request.getSession().getAttribute("users");
		orders.setuId(users.getId());
		System.out.println(address);
		orders.setAddressee(address.substring(address.indexOf("收货人：")+4, address.indexOf("，收货地址")));
		orders.setAddress(address.substring(address.indexOf("收货地址：")+5, address.indexOf("，联系电话")));
		orders.setPhonenumber(address.substring(address.indexOf("联系电话：")+5));
		orders.setStatu("待付款");
		orders.setCreationtime(new Date());
		System.out.println(orders);
		int oid=ordersService.newOrders(orders).getId();
		System.out.println(oid);
		List<Orderitems> list=new ArrayList<Orderitems>();
		for (int i = 0; i < gid.length; i++) {
			Orderitems orderitems=new Orderitems();
			orderitems.setSkuId(gid[i]);
			orderitems.setNumber(number[i]);
			orderitems.setPrice(goodsSkuService.getSkuById(gid[i]).getPrice());
			orderitems.setoId(oid);
			ordersitemsService.addOrderitems(orderitems);
			list.add(orderitems);
		}
		orders.setOrderitems(list);
		for (Orderitems orderitems : orders.getOrderitems()) {
			System.out.println(orderitems);
		}
		
		TwoDimensionalCode twoDimensionalCode=new TwoDimensionalCode();
//		System.out.println(request.getRequestURI());
//		String requesturl=
		String payUrl="http://192.168.0.9:8080/ssm_mall_2/pay?oid="+oid;
		System.out.println(payUrl);
		BufferedImage bufferedImage=twoDimensionalCode.createCode(payUrl);
//		try {
//			ImageIO.write(bufferedImage, "png", response.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Msg msg=new Msg();
//		
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		try {
			ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 byte[] bytes = byteArrayOutputStream.toByteArray();
//		 BASE64Encoder 
//		
//		msg.addData("twoDimensionalCode", value)
		String img="data:image/png;base64,"+Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
		msg.addData("img", img).addData("orderid", oid);
		if (byteArrayOutputStream!=null) {
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byteArrayOutputStream=null;
		}
		
		
		return msg;
		
	}
//	
	@RequestMapping("pay")
	public String pay(Integer oid) {
		Orders orders=new Orders();
		orders.setId(oid);
		orders.setStatu("待发货");
		ordersService.paySuccess(orders);
//		Orders orders2=ordersService.getOrdersById(oid);
		for (Orderitems orderitems : ordersService.getOrdersById(oid).getOrderitems()) {
			System.out.println(orderitems);
			GoodsSku goodsSku=orderitems.getGoodsSku();
			goodsSku.setInventory(goodsSku.getInventory()-orderitems.getNumber());
			goodsSku.setSalesvolume(goodsSku.getSalesvolume()+orderitems.getNumber());
			goodsSkuService.updateGoodsSku(goodsSku);
		}
		
		
		System.out.println("支付成功"+oid);
		return null;
	}
	
//	
//	
	@RequestMapping(value = "orders",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Orders> getOrdersAjax(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,HttpServletRequest request ) {
		PageHelper.startPage(pageNumber, 8);
		Users users=(Users) request.getSession().getAttribute("users");
		List<Orders> list=ordersService.getgetOrdersByUid(users.getId());
		PageInfo<Orders> pageInfo=new PageInfo<Orders>(list, 5);
		for (Orders orders : list) {
			System.out.println(orders);
			for (Orderitems orderitems : orders.getOrderitems()) {
				System.out.println(orderitems);
			}
		}
		return pageInfo;
	}
//	
	@RequestMapping(value = "confirm" ,method = RequestMethod.POST)
	@ResponseBody
	public boolean confirm(Integer oId) {
		if (ordersService.confirm(oId)>0) {
			return true;
		}else {
			return false;
		}
	}
//	
//	
////	@RequestMapping("adminOrders1")
////	public String adminOrders1(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,Model model,HttpServletRequest request ) {
////		PageHelper.startPage(pageNumber, 8);
////		Users users=(Users) request.getSession().getAttribute("users");
////		List<Orders> list=ordersService.getgetOrdersByUid(users.getuId());
////		PageInfo<Orders> pageInfo=new PageInfo<Orders>(list, 5);
////		model.addAttribute("pageInfo", pageInfo);
////		for (Orders orders : list) {
////			System.out.println(orders);
////			for (Orderitems orderitems : orders.getOrderitems()) {
////				System.out.println(orderitems);
////			}
////		}
////		return "admin/ordersList";
////	}
//	
	@RequestMapping("adminOrders")
	@ResponseBody
	public PageInfo<Orders> adminOrders(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Orders> list=ordersService.getAllOrders();
		PageInfo<Orders> pageInfo=new PageInfo<Orders>(list,5);
		
		return pageInfo;
	}
//	
//	
//	
////	@RequestMapping("neworders")
////	public String newOrders(Integer[] gid,Integer[] number,BigDecimal[] price,String address,HttpServletRequest request) {
////		Orders orders=new Orders();
////		Users users=(Users) request.getSession().getAttribute("users");
////		orders.setuId(users.getuId());
////		System.out.println(address);
////		orders.setoAddressee(address.substring(address.indexOf("收货人：")+4, address.indexOf("，收货地址")));
////		orders.setoAddress(address.substring(address.indexOf("收货地址：")+5, address.indexOf("，联系电话")));
////		orders.setoPhonenumber(address.substring(address.indexOf("联系电话：")+5));
////		orders.setoStatu("待发货");
////		System.out.println(orders);
////		int oid=ordersService.newOrders(orders).getoId();
////		System.out.println(oid);
////		List<Orderitems> list=new ArrayList<Orderitems>();
////		for (int i = 0; i < gid.length; i++) {
////			Orderitems orderitems=new Orderitems();
////			orderitems.setgId(gid[i]);
////			orderitems.setiNumber(number[i]);
////			orderitems.setiPrice(goodsService.getGoodsDetails(gid[i]).getgPrice());
////			orderitems.setoId(oid);
////			ordersitemsService.addOrderitems(orderitems);
////			list.add(orderitems);
////		}
////		orders.setOrderitems(list);
////		for (Orderitems orderitems : orders.getOrderitems()) {
////			System.out.println(orderitems);
////		}
////		
////		return null;
////	}
////	
	
	
	
}
