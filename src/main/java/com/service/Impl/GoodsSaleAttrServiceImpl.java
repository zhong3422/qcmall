package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GoodsSaleAttr;
import com.dao.GoodsSaleAttrMapper;
import com.service.GoodsSaleAttrService;

@Service("goodsSaleAttrService")
public class GoodsSaleAttrServiceImpl implements GoodsSaleAttrService{

	@Autowired
	private GoodsSaleAttrMapper goodsSaleAttrMapper;

	@Override
	public int addGoodsSaleAttr(GoodsSaleAttr goodsSaleAttr) {
		// TODO Auto-generated method stub
		goodsSaleAttrMapper.insertSelective(goodsSaleAttr);
		return goodsSaleAttrMapper.selectNewgoodsSaleAttr().getId();
	}
	
}
