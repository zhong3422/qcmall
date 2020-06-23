package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

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


import com.bean.GoodsImages;
import com.bean.GoodsSaleAttr;
import com.bean.GoodsSaleAttrValue;
import com.bean.GoodsSku;
import com.bean.GoodsSkuSaleAttrValue;
import com.bean.GoodsSpu;
import com.bean.Msg;
import com.bean.Orders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AddressService;
import com.service.GoodsImagesService;
import com.service.GoodsSaleAttrService;
import com.service.GoodsSaleAttrValueService;
import com.service.GoodsService;
import com.service.GoodsSkuService;
import com.service.GoodsSpuService;
import com.service.ImagesService;

@Controller
public class GoodsSpuController {

	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsSkuService goodsSkuService;
	@Autowired
	private GoodsSpuService goodsSpuService;
	@Autowired
	private GoodsSaleAttrService goodsSaleAttrService;
	@Autowired
	private GoodsSaleAttrValueService goodsSaleAttrValueService;
	@Autowired
	private GoodsImagesService goodsImagesService;
	
	
	@RequestMapping("goodsList")
	@ResponseBody
	public PageInfo<GoodsSpu> spuList(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber,@RequestParam(value = "size",defaultValue = "8")Integer size,@RequestParam(value = "order",defaultValue = "id desc")String order) {
		PageHelper.startPage(pageNumber, size);
		PageHelper.startPage(pageNumber, size,order);
		List<GoodsSpu> list=goodsSpuService.getSpuList();
		PageInfo<GoodsSpu> pageInfo=new PageInfo<GoodsSpu>(list, 5);
		return pageInfo;
	}
	
	@RequestMapping("adminSpuList")
	@ResponseBody
	public PageInfo<GoodsSpu> adminSpuList(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber,@RequestParam(value = "size",defaultValue = "8")Integer size) {
		PageHelper.startPage(pageNumber, size);
		List<GoodsSpu> list=goodsSpuService.getSpuList();
		PageInfo<GoodsSpu> pageInfo=new PageInfo<GoodsSpu>(list, 5);
		return pageInfo;
	}
	
	
	
	@RequestMapping(value = "/spu/{gid}",method = RequestMethod.GET)
	public String spu(@PathVariable Integer gid,Model model) {
		GoodsSpu goodsSpu=goodsService.getGoodsBySpu(gid);
		System.out.println(goodsSpu);
		for (GoodsSaleAttr goodsSaleAttr : goodsSpu.getGoodsSaleAttrs()) {
			System.out.println(goodsSaleAttr);
			for (GoodsSaleAttrValue goodsSaleAttrValue : goodsSaleAttr.getGoodsSaleAttrValues()) {
				System.out.println(goodsSaleAttrValue);
			}
		}
		
		List<GoodsSku> skus=goodsSkuService.getSkuWithVidBySkuId(gid);
		System.out.println(skus.size());
		for (GoodsSku goodsSku : skus) {
			System.out.println(goodsSku);
//			for (GoodsSkuSaleAttrValue value : goodsSku.()) {
//				System.out.println(value);
//			}
		}
		for (GoodsImages goodsImages : goodsSpu.getGoodsImages()) {
			System.out.println(goodsImages);
		}
		model.addAttribute("spu", goodsSpu);
//		model.addAttribute("skus", skus);
		return "spu/spuDetails";
	}
	
	
	
	@RequestMapping(value = "/adminSpu/{gid}",method = RequestMethod.GET)
	public String adminSpu(@PathVariable Integer gid,Model model) {
		GoodsSpu goodsSpu=goodsService.getGoodsBySpu(gid);
		System.out.println(goodsSpu);
		for (GoodsSaleAttr goodsSaleAttr : goodsSpu.getGoodsSaleAttrs()) {
			System.out.println(goodsSaleAttr);
			for (GoodsSaleAttrValue goodsSaleAttrValue : goodsSaleAttr.getGoodsSaleAttrValues()) {
				System.out.println(goodsSaleAttrValue);
			}
		}
		
		List<GoodsSku> skus=goodsSkuService.getSkuWithVidBySkuId(gid);
		System.out.println(skus.size());
		for (GoodsSku goodsSku : skus) {
			System.out.println(goodsSku);
//			for (GoodsSkuSaleAttrValue value : goodsSku.()) {
//				System.out.println(value);
//			}
		}
		model.addAttribute("spu", goodsSpu);
//		model.addAttribute("skus", skus);
		return "admin/spuDetails";
	}
	
	
	
	
	@RequestMapping(value = "spu",method = RequestMethod.POST)
	@ResponseBody
	public int addSpu(GoodsSpu goodsSpu,Integer[] saleAttrId,@RequestParam("saleAttrValue") String[] saleAttrValue,@RequestParam("saleAttrIndex") Integer[] saleAttrIndex) {
		System.out.println(goodsSpu);
		System.out.println("----saleAttrValue------");
		for (String sting : saleAttrValue) {
			System.out.println(sting);
		}
		System.out.println("saleAttrIndex"+saleAttrIndex);
		int spuid=goodsSpuService.addSpu(goodsSpu);
//		int spuid=1000;
		System.out.println("spuId:"+spuid);
//		for (Integer integer : saleAttrId) {
//			GoodsSaleAttr goodsSaleAttr=new GoodsSaleAttr();
//			goodsSaleAttr.setSpuId(spuid);
//			goodsSaleAttr.setSaleAttrId(integer);
//			System.out.println(goodsSaleAttr);
//			int sid=goodsSaleAttrService.addGoodsSaleAttr(goodsSaleAttr);
//		}
		for (int i = 0; i < saleAttrId.length; i++) {
			GoodsSaleAttr goodsSaleAttr=new GoodsSaleAttr();
			goodsSaleAttr.setSpuId(spuid);
			goodsSaleAttr.setSaleAttrId(saleAttrId[i]);
			System.out.println(goodsSaleAttr);
			int sid=goodsSaleAttrService.addGoodsSaleAttr(goodsSaleAttr);
			for (int j = 0; j < saleAttrIndex.length; j++) {
				if (saleAttrIndex[j]==i) {
					GoodsSaleAttrValue goodsSaleAttrValue=new GoodsSaleAttrValue();
					goodsSaleAttrValue.setSaleAttrId(sid);
					goodsSaleAttrValue.setValue(saleAttrValue[j]);
					goodsSaleAttrValue.setSpuId(spuid);
					goodsSaleAttrValueService.addGoodsSaleAttrValue(goodsSaleAttrValue);
					
					System.out.println(goodsSaleAttrValue);
					
					
				}
			}
			
			
		}
		
		
		return spuid;
	}
	
	
//	MultipartFile  file[0].getOriginalFilename()
	@RequestMapping("imageUpload")
	@ResponseBody
	public GoodsImages imageUpload(@RequestParam("file") MultipartFile file,Integer spuid,HttpServletRequest httpServletRequest) {
		System.out.println("spuid:"+spuid);
		GoodsImages goodsImages=new GoodsImages();
		
		System.out.println("---------");
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
//		String fileName1=""+spuid+"_"+new Date().getTime()+new Random().nextInt(100000)+
//				file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		StringBuilder fileName=new StringBuilder();
		fileName.append(spuid).append("_").append(new Date().getTime())
			.append(new Random().nextInt(100000))
			.append(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
		
		goodsImages.setPath("image/goodsSpu/"+fileName.toString());
		goodsImages.setgId(spuid);
		
		try {
			file.transferTo(new File(httpServletRequest.getSession().getServletContext().getRealPath("/")
					+ "image/goodsSpu/" + fileName.toString()));
			goodsImagesService.addImage(goodsImages);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return goodsImages;
	}
	
	@RequestMapping("baseImageUpload")
	@ResponseBody
	public GoodsSpu baseImageUpload(@RequestParam("file") MultipartFile file,Integer spuid,HttpServletRequest httpServletRequest) {
		System.out.println("spuid:"+spuid);
		GoodsSpu goodsSpu=new GoodsSpu();
		goodsSpu.setId(spuid);
		
		System.out.println("---------");
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
//		String fileName1=""+spuid+"_"+new Date().getTime()+new Random().nextInt(100000)+
//				file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		StringBuilder fileName=new StringBuilder();
		fileName.append(spuid).append("_").append(new Date().getTime())
		.append(new Random().nextInt(100000))
		.append(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
		
		goodsSpu.setImage("image/goodsSpu/"+fileName.toString());
		
		try {
			file.transferTo(new File(httpServletRequest.getSession().getServletContext().getRealPath("/")
					+ "image/goodsSpu/" + fileName.toString()));
			goodsSpuService.updateSpu(goodsSpu);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return goodsSpu;
	}
	
	
	@RequestMapping("keywordsSearch")
	@ResponseBody
	public PageInfo<GoodsSpu> keywordsSearch(String Keyword) {
		Keyword=Keyword.replace(" ", "%");
		PageHelper.startPage(1, 5);
		List<GoodsSpu> list=goodsSpuService.keywordsSearch(Keyword);
		PageInfo<GoodsSpu> pageInfo=new PageInfo<GoodsSpu>(list);
		return pageInfo;
	}
	
	@RequestMapping("searchSpu")
	@ResponseBody
	public PageInfo<GoodsSpu> searchSpu(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber,@RequestParam(value = "size",defaultValue = "8")Integer size,@RequestParam(value = "order",defaultValue = "id desc")String order,String keyword) {
		PageHelper.startPage(pageNumber, size);
		PageHelper.startPage(pageNumber, size,order);
		List<GoodsSpu> list=goodsSpuService.searchSpu(keyword);
		PageInfo<GoodsSpu> pageInfo=new PageInfo<GoodsSpu>(list, 5);
		return pageInfo;
	}
	
	
}
