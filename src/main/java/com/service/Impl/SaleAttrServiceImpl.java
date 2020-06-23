package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.SaleAttr;
import com.dao.SaleAttrMapper;
import com.service.SaleAttrService;

@Service("saleAttrService")
public class SaleAttrServiceImpl implements SaleAttrService{

	@Autowired
	private SaleAttrMapper saleAttrMapper;

	@Override
	public List<SaleAttr> getSaleAttrs() {
		// TODO Auto-generated method stub
		return saleAttrMapper.selectByExample(null);
	}
	
}
