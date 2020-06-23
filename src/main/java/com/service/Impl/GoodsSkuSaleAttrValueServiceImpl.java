package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GoodsSkuSaleAttrValue;
import com.dao.GoodsSkuSaleAttrValueMapper;
import com.service.GoodsSkuSaleAttrValueService;

@Service("goodsSkuSaleAttrValueService")
public class GoodsSkuSaleAttrValueServiceImpl implements GoodsSkuSaleAttrValueService{

	@Autowired
	private GoodsSkuSaleAttrValueMapper goodsSkuSaleAttrValueMapper;

	@Override
	public void addGoodsSkuSaleAttrValue(GoodsSkuSaleAttrValue goodsSkuSaleAttrValue) {
		// TODO Auto-generated method stub
		goodsSkuSaleAttrValueMapper.insertSelective(goodsSkuSaleAttrValue);
	}
	
	
	
	
	
}
