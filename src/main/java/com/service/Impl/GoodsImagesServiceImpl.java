package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GoodsImages;
import com.dao.GoodsImagesMapper;
import com.service.GoodsImagesService;

@Service("GoodsImagesService")
public class GoodsImagesServiceImpl implements GoodsImagesService{

	@Autowired
	private GoodsImagesMapper goodsImagesMapper;

	@Override
	public void addImage(GoodsImages goodsImages) {
		// TODO Auto-generated method stub
		goodsImagesMapper.insertSelective(goodsImages);
	}

	
	
	
	
}
