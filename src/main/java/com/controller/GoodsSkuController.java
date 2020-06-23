package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Address;
import com.bean.GoodsSku;
import com.bean.GoodsSkuSaleAttrValue;
import com.bean.Orderitems;
import com.bean.Users;
import com.service.AddressService;
import com.service.GoodsSkuSaleAttrValueService;
import com.service.GoodsSkuService;

@Controller
public class GoodsSkuController {

	@Autowired
	private GoodsSkuService goodsSkuService;
	@Autowired
	private GoodsSkuSaleAttrValueService goodsSkuSaleAttrValueService;
	@Autowired
	private AddressService addressService;
	
	
	@RequestMapping("getSkuKey")
	@ResponseBody
	public Map<String, String> getSkuKy(@RequestParam Integer id) {
		
		List<GoodsSku> skus=goodsSkuService.getSkuWithVidBySkuId(id);
//		String json="'sku':[";
//		StringBuilder json=new StringBuilder();
//		json.append("'sku':[");
		System.out.println(skus.size());
		Map<String, String> map=new HashMap<String, String>();
		
		JSONArray jsonArray=new JSONArray();
		for (GoodsSku goodsSku : skus) {
			String v=goodsSku.getId()+"";
			String k="";
			System.out.println(goodsSku);
//			String j="{";
			for (GoodsSkuSaleAttrValue value : goodsSku.getGoodsSkuSaleAttrValues()) {
//				j+="'key:'"+value.getValueId()+"|";
				k=k+value.getValueId()+"|";
				System.out.println(value);
			}
			map.put(k, v);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("value",v);
			jsonObject.put("key", k);
			jsonArray.put(jsonObject);
		}
//		jsonArray.put(map);
//		jsonArray.put
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put("keys", jsonArray);
//		System.out.println(jsonObject);
		String json="{keys: "+jsonArray+"}";
		return map;
	}
	
	
	@RequestMapping(value = "/sku/{id}",method = RequestMethod.GET)
	@ResponseBody
	public GoodsSku getGoodsSku(@PathVariable Integer id) {
		GoodsSku goodsSku=goodsSkuService.getSkuById(id);
		return goodsSku;
	}
	
	@RequestMapping("addSku")
	@ResponseBody
	public boolean addSku(GoodsSku goodsSku,Integer[] saleAttrId,String valueString) {
		System.out.println(goodsSku);
		int skuid=goodsSkuService.addSku(goodsSku);
		
		String value[]=valueString.split("\\|");
		for (String string : value) {
			System.out.println(string);
		}
		
		for (int i = 0; i < saleAttrId.length; i++) {
			GoodsSkuSaleAttrValue goodsSkuSaleAttrValue=new GoodsSkuSaleAttrValue();
			goodsSkuSaleAttrValue.setSkuId(skuid);
			goodsSkuSaleAttrValue.setSaleAttrId(saleAttrId[i]);
			goodsSkuSaleAttrValue.setValueId(Integer.valueOf(value[i]));
			goodsSkuSaleAttrValueService.addGoodsSkuSaleAttrValue(goodsSkuSaleAttrValue);
			System.out.println(goodsSkuSaleAttrValue);
		}
		
		return true;
	}
	
	
	
	@RequestMapping("/forebuy")
	public String forebuy(Integer[] gId,Integer[] number,String[] check,Model model,HttpServletRequest request) {
//		for (String string : check) {
//			System.out.println(string);
//		}
		List<Orderitems> ilist=new ArrayList<Orderitems>();
		for (int i = 0; i < gId.length; i++) {
			Orderitems orderitems=new Orderitems();
//			orderitems.setGoods(goodsService.getGoodsDetails(gId[i]));
			orderitems.setGoodsSku(goodsSkuService.getSkuById(gId[i]));
			orderitems.setNumber(number[i]);
			ilist.add(orderitems);
		}
		Users users=(Users) request.getSession().getAttribute("users");
		List<Address> aList=addressService.getUsersAddress(users.getId());
		for (Orderitems orderitems : ilist) {
			System.out.println(orderitems);
		}
		for (Address address : aList) {
			System.out.println(address);
		}
		model.addAttribute("orderitems", ilist);
		model.addAttribute("address", aList);
	
		
		return "goods/forebuy";
	}
	
	
	
	
	
}
