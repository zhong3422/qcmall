package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Goodscarts;
import com.bean.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.GoodscartsService;

@Controller
public class GoodscartsController {

	
	@Autowired
	private GoodscartsService goodscartsService;
	
	@RequestMapping(value = "/goodsCarts",method = RequestMethod.POST)
	@ResponseBody
	public Goodscarts addGoodsToCart(@RequestBody Goodscarts goodscarts,HttpServletRequest httpServletRequest) {
		Users users=(Users) httpServletRequest.getSession().getAttribute("users");
		goodscarts.setuId(users.getId());
		System.out.println(goodscarts);
		goodscartsService.addGoodsCarts(goodscarts);
//		httpServletResponse.setCharacterEncoding("utf-8");
//		return "加入购物车成功";
		return goodscarts;
	}
	
//	@RequestMapping(value = "/goodsCarts",method = RequestMethod.GET)
//	public String getGoodsCarts(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,HttpServletRequest httpServletRequest,Model model ) {
//		//System.out.println(pageNumber);
//		PageHelper.startPage(pageNumber, 5);
//		Users users= (Users) httpServletRequest.getSession().getAttribute("users");
////		List<Goodscarts> list=goodscartsService.getGoodsCartsByUid(users.getuId());
////		PageInfo<Goodscarts> pageInfo=new PageInfo<Goodscarts>(list, 5);
////		model.addAttribute("pageInfo", pageInfo);
//		
//		return "goodscarts/cartslist";
//	}
	
	@RequestMapping(value = "/goodsCarts",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Goodscarts> getGoodsCarts(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,HttpServletRequest httpServletRequest ) {
		//System.out.println(pageNumber);
		PageHelper.startPage(pageNumber, 5);
		Users users= (Users) httpServletRequest.getSession().getAttribute("users");
		List<Goodscarts> list=goodscartsService.getGoodsCartsByUid(users.getId());
		PageInfo<Goodscarts> pageInfo=new PageInfo<Goodscarts>(list, 5);
//		model.addAttribute("pageInfo", pageInfo);
		
		return pageInfo;
	}
	
	
	@RequestMapping(value = "/goodsCarts/{cid}",method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteGoodscarts(@PathVariable Integer cid,HttpServletRequest httpServletRequest,Model model ) {
		System.out.println(cid);
		goodscartsService.delete(cid);
		System.out.println("删除购物车商品");
		return "success";
	}
	
	@RequestMapping(value = "/updateGoodsCarts",method = RequestMethod.POST)
	@ResponseBody
	public boolean updateGoodscarts(Goodscarts goodscarts) {
//		System.out.println(goodscarts);
		int n=goodscartsService.updateGoodscarts(goodscarts);
		if (n>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
