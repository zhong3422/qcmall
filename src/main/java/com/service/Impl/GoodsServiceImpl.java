package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GoodsSpu;
//import com.bean.Goods;
//import com.bean.GoodsExample;
//import com.bean.GoodsExample.Criteria;
//import com.bean.GoodsSpu;
//import com.dao.GoodsMapper;
import com.dao.GoodsSpuMapper;
import com.service.GoodsService;



@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

//	@Autowired
//	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsSpuMapper goodsSpuMapper;
//	
//	@Autowired
//	private GoodsSpuMapper goodsSpuMapper;
//	
//	@Override
//	public int releaseGoods(Goods goods) {
//		// TODO Auto-generated method stub
//		goodsMapper.insertSelective(goods);
////		int id=goodsMapper.getNewGoodsId();
////		return id;
//		return 0;
//	}
//
//	@Override
//	public List<Goods> getGoodsList() {
//		// TODO Auto-generated method stub
////		return goodsMapper.selectByExample(null);
//		return goodsMapper.selectByExample(null);
//	}
//
//	@Override
//	public int updateGoods(Goods goods) {
//		// TODO Auto-generated method stub
//		System.out.println(goods);
//		System.out.println("商品信息更新成功");
//		return goodsMapper.updateByPrimaryKeySelective(goods);
//	}
//
//	@Override
//	public Goods getGoodsDetails(Integer gid) {
//		// TODO Auto-generated method stub
////		return goodsMapper.selectWithImagesByPrimaryKey(gid);
//		return null;
//	}
//
//	@Override
//	public List<Goods> Seachgoods(String keyword) {
//		// TODO Auto-generated method stub
//		GoodsExample example=new GoodsExample();
////		example.or().andGNameLike(keyword);
//		example.createCriteria().andNameLike(keyword);
//		return goodsMapper.selectByExample(example);
//	}
//
//	@Override
//	public List<Goods> getGoodsListOrderBygSalesvolume() {
//		// TODO Auto-generated method stub
//		GoodsExample example=new GoodsExample();
//		example.setOrderByClause("goods.g_salesvolume DESC");
//		return goodsMapper.selectByExample(example);
//	}
//
	@Override
	public GoodsSpu getGoodsBySpu(Integer gid) {
		// TODO Auto-generated method stub
//		return goodsSpuMapper.selectByPrimaryKey(gid);
		return goodsSpuMapper.selectWithDetailsByPrimaryKey(gid);
	}

}
