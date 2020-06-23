package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GoodsSku;
import com.bean.GoodsSkuExample;
import com.dao.GoodsSkuMapper;
import com.service.GoodsSkuService;

@Service("goodsSkuService")
public class GoodsSkuServiceImpl implements GoodsSkuService{

	@Autowired
	private GoodsSkuMapper goodsSkuMapper;
	
	@Override
	public List<GoodsSku> getSkuWithVidBySkuId(Integer gid) {
		// TODO Auto-generated method stub
//		return null;
		GoodsSkuExample example=new GoodsSkuExample();
		example.createCriteria().andSpuIdEqualTo(gid);
		System.out.println("goodsSkuService---------");
		return goodsSkuMapper.selectWithDetailsByExample(example);
	}

	@Override
	public GoodsSku getSkuById(Integer id) {
		// TODO Auto-generated method stub
//		return goodsSkuMapper.selectByPrimaryKey(id);
		return goodsSkuMapper.selectWithDetailsByPrimaryKey(id);
	}

	@Override
	public int addSku(GoodsSku goodsSku) {
		// TODO Auto-generated method stub
		goodsSkuMapper.insertSelective(goodsSku);
		
		return goodsSkuMapper.selectNewSku().getId();
	}

	@Override
	public void updateGoodsSku(GoodsSku goodsSku) {
		// TODO Auto-generated method stub
		goodsSkuMapper.updateByPrimaryKeySelective(goodsSku);
	}

}
