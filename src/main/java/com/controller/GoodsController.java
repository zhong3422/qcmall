package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Address;
//import com.bean.Goods;
import com.bean.GoodsSaleAttr;
import com.bean.GoodsSaleAttrValue;
import com.bean.GoodsSku;
import com.bean.GoodsSkuSaleAttrValue;
import com.bean.GoodsSpu;
//import com.bean.Images;
import com.bean.Orderitems;
import com.bean.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AddressService;
import com.service.GoodsService;
import com.service.GoodsSkuService;
import com.service.ImagesService;
//import com.sun.accessibility.internal.resources.accessibility;

@Controller
public class GoodsController {

	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ImagesService imagesService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private GoodsSkuService goodsSkuService;
	
//	@RequestMapping(value = "/spu/{gid}",method = RequestMethod.GET)
//	public String spu(@PathVariable Integer gid,Model model) {
//		GoodsSpu goodsSpu=goodsService.getGoodsBySpu(gid);
//		System.out.println(goodsSpu);
//		for (GoodsSaleAttr goodsSaleAttr : goodsSpu.getGoodsSaleAttrs()) {
//			System.out.println(goodsSaleAttr);
//			for (GoodsSaleAttrValue goodsSaleAttrValue : goodsSaleAttr.getGoodsSaleAttrValues()) {
//				System.out.println(goodsSaleAttrValue);
//			}
//		}
//		
////		List<GoodsSku> skus=goodsSkuService.getSkuWithVidBySkuId(gid);
////		System.out.println(skus.size());
////		for (GoodsSku goodsSku : skus) {
////			System.out.println(goodsSku);
////			for (GoodsSkuSaleAttrValue value : goodsSku.getGoodsSkuSaleAttrValues()) {
////				System.out.println(value);
////			}
////		}
//		
//		return "spu/spuDetails";
//	}
	
//	@RequestMapping("/releaseGoods")
//	public String releaseGoods(Goods goods,@RequestParam("file") MultipartFile[] file,HttpServletRequest httpServletRequest) {
//		System.out.println(goods);
//		int gid=goodsService.releaseGoods(goods);
//		goods.setgId(gid);
//		System.out.println(gid);
//		int i=0;
//		System.out.println(file.length);
//		System.out.println(file[0].getSize());
//		if (file[0].getSize()>0) {
//			goods.setgImage(gid + "_" + 0 + file[0].getOriginalFilename().substring(file[0].getOriginalFilename().lastIndexOf(".")));
//			goodsService.updateGoods(goods);
//			for (MultipartFile multipartFile : file) {
//				try {
//					String imagename = gid + "_" + (i++) + multipartFile.getOriginalFilename()
//							.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
//					multipartFile
//							.transferTo(new File(httpServletRequest.getSession().getServletContext().getRealPath("/")
//									+ "image/goods/" + imagename));
//					Images images = new Images(null, gid, imagename);
//					imagesService.addImages(images);
//
//				} catch (IllegalStateException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} 
//		}
//		return null;
//	}
//	
//	
//	@RequestMapping("/adminGoodsList")
//	public String getGoodsList2(@RequestParam(value = "pageNumber",defaultValue = "1")  Integer pageNumber,Model model) {
//		PageHelper.startPage(pageNumber, 5);
//		List<Goods> list=goodsService.getGoodsList();
//		PageInfo<Goods> pageInfo=new PageInfo<Goods>(list,5);
//		model.addAttribute("pageInfo", pageInfo);
//		return "admin/goodsList";
//		
//	}
//	
//	@RequestMapping("/getGoodsList")
//	public String getGoodsList(@RequestParam(value = "pageNumber",defaultValue = "1")  Integer pageNumber,Model model) {
//		PageHelper.startPage(pageNumber, 4);
//		List<Goods> list=goodsService.getGoodsList();
//		PageInfo<Goods> pageInfo=new PageInfo<Goods>(list,5);
//		model.addAttribute("pageInfo", pageInfo);
//		return "goods/goodsList";
//		
//	}
//	
//	@RequestMapping("/seachGoods")
//	public String Seachgoods(String keyword,@RequestParam(value = "pageNumber",defaultValue = "1")  Integer pageNumber,Model model) {
//		PageHelper.startPage(pageNumber, 12);
//		List<Goods> list=goodsService.Seachgoods("%"+keyword+"%");
//		PageInfo<Goods> pageInfo=new PageInfo<Goods>(list,5);
////		for (Goods goods : list) {
////			System.out.println(goods);
////		}
//		model.addAttribute("pageInfo", pageInfo);
//		return "goods/seachGoods";
//	}
//	
//	
//	
//	@RequestMapping("/seachGoodsJson")
//	@ResponseBody
//	public PageInfo<Goods> SeachgoodsJson(String keyword,@RequestParam(value = "pageNumber",defaultValue = "1")  Integer pageNumber) {
//		PageHelper.startPage(pageNumber, 12);
//		List<Goods> list=goodsService.Seachgoods("%"+keyword+"%");
//		PageInfo<Goods> pageInfo=new PageInfo<Goods>(list,5);
////		for (Goods goods : list) {
////			System.out.println(goods);
////		}
////		model.addAttribute("pageInfo", pageInfo);
//		return pageInfo;
//	}
//	
//	
//	
//	
//	
//	@RequestMapping("/getGoodsListWithJson")
//	@ResponseBody
//	public PageInfo<Goods> getGoodsListWithJson(@RequestParam(value = "pageNumber",defaultValue = "1")  Integer pageNumber,Model model) {
//		PageHelper.startPage(pageNumber, 12);
//		List<Goods> list=goodsService.getGoodsListOrderBygSalesvolume();
//		PageInfo<Goods> pageInfo=new PageInfo<Goods>(list,5);
//		model.addAttribute("pageInfo", pageInfo);
//		return pageInfo;
//		
//	}
//	
//	@RequestMapping(value = "/goodsDetails/{gid}",method = RequestMethod.GET)
//	public String getGoodsDetails(@PathVariable Integer gid,Model model) {
//		Goods goods=goodsService.getGoodsDetails(gid);
//		System.out.println(goods.getImagesList().size());
//		for (Images images : goods.getImagesList()) {
//			System.out.println(images);
//		}
//		model.addAttribute("goods", goods);
//		return "goods/goodsDetails";
//	}
//	
//	
//	@RequestMapping("/forebuy")
//	public String forebuy(Integer[] gId,Integer[] number,String[] check,Model model,HttpServletRequest request) {
////		for (String string : check) {
////			System.out.println(string);
////		}
//		List<Orderitems> ilist=new ArrayList<Orderitems>();
//		for (int i = 0; i < gId.length; i++) {
//			Orderitems orderitems=new Orderitems();
//			orderitems.setGoods(goodsService.getGoodsDetails(gId[i]));
//			orderitems.setiNumber(number[i]);
//			ilist.add(orderitems);
//		}
//		Users users=(Users) request.getSession().getAttribute("users");
//		List<Address> aList=addressService.getUsersAddress(users.getuId());
//		for (Orderitems orderitems : ilist) {
//			System.out.println(orderitems);
//		}
//		for (Address address : aList) {
//			System.out.println(address);
//		}
//		model.addAttribute("orderitems", ilist);
//		model.addAttribute("address", aList);
//	
//		
//		return "goods/forebuy";
//	}
//	
	
	
	
}
