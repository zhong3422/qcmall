package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.SaleAttr;
import com.service.SaleAttrService;

@Controller
public class SaleAttrController {

	@Autowired
	private SaleAttrService saleAttrService;
	
	
	@RequestMapping(value = "/saleAttr",method = RequestMethod.GET)
	@ResponseBody
	public List<SaleAttr> getSaleAttrs() {
		List<SaleAttr> list=saleAttrService.getSaleAttrs();
		return list;
	}
	
	
	
}
