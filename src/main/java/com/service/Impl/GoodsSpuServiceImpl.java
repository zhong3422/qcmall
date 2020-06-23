package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GoodsSpu;
import com.bean.GoodsSpuExample;
import com.dao.GoodsSpuMapper;
import com.service.GoodsSpuService;

@Service("goodsSpuService")
public class GoodsSpuServiceImpl implements GoodsSpuService{

	@Autowired
	private GoodsSpuMapper goodsSpuMapper;

	@Override
	public int addSpu(GoodsSpu goodsSpu) {
		// TODO Auto-generated method stub
		goodsSpuMapper.insertSelective(goodsSpu);
		return goodsSpuMapper.selectNewSpu().getId();
	}

	@Override
	public void updateSpu(GoodsSpu goodsSpu) {
		// TODO Auto-generated method stub
		goodsSpuMapper.updateByPrimaryKeySelective(goodsSpu);
	}

	@Override
	public List<GoodsSpu> getSpuList() {
		// TODO Auto-generated method stub
		return goodsSpuMapper.selectByExample(null);
	}

	@Override
	public List<GoodsSpu> keywordsSearch(String keyword) {
		// TODO Auto-generated method stub
		GoodsSpuExample example=new GoodsSpuExample();
		example.createCriteria().andNameLike("%"+keyword+"%");
		example.setOrderByClause("name");
		return goodsSpuMapper.keywordsSearch(example);
	}

	@Override
	public List<GoodsSpu> searchSpu(String keyword) {
		// TODO Auto-generated method stub
		GoodsSpuExample example=new GoodsSpuExample();
		example.createCriteria().andNameLike("%"+keyword+"%");
		return goodsSpuMapper.selectByExample(example);
	}
	
}
