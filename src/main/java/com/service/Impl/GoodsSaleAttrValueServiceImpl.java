package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GoodsSaleAttrValue;
import com.dao.GoodsSaleAttrValueMapper;
import com.service.GoodsSaleAttrValueService;

@Service("goodsSaleAttrValueService")
public class GoodsSaleAttrValueServiceImpl implements GoodsSaleAttrValueService{

	@Autowired
	private GoodsSaleAttrValueMapper goodsSaleAttrValueMapper;

	@Override
	public void addGoodsSaleAttrValue(GoodsSaleAttrValue goodsSaleAttrValue) {
		// TODO Auto-generated method stub
		goodsSaleAttrValueMapper.insertSelective(goodsSaleAttrValue);
	}
	
}
