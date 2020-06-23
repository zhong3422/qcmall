package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Goodscarts;
import com.bean.GoodscartsExample;
import com.dao.GoodscartsMapper;
import com.service.GoodscartsService;

@Service("goodscartsService")
public class GoodscartsServiceImpl implements GoodscartsService{

	@Autowired
	private GoodscartsMapper goodscartsMapper;
	
	@Override
	public void addGoodsCarts(Goodscarts goodscarts) {
		// TODO Auto-generated method stub
		
		GoodscartsExample example=new GoodscartsExample();
		example.createCriteria().andSkuIdEqualTo(goodscarts.getSkuId()).andUIdEqualTo(goodscarts.getuId());
		List<Goodscarts> list=goodscartsMapper.selectByExample(example);
		if (list.size()>0) {
			Goodscarts goodscarts2=list.get(0);
			goodscarts2.setNumber(goodscarts2.getNumber()+goodscarts.getNumber());
			goodscartsMapper.updateByPrimaryKeySelective(goodscarts2);
		}else {
			goodscartsMapper.insertSelective(goodscarts);
		}
		
		
	}

	@Override
	public List<Goodscarts> getGoodsCartsByUid(Integer uid) {
		// TODO Auto-generated method stub
		GoodscartsExample example=new GoodscartsExample();
		example.createCriteria().andUIdEqualTo(uid);
		example.setOrderByClause("goodscarts.id DESC");
//		return goodscartsMapper.selectByExample(example);
		return goodscartsMapper.selectWithDetailsByExample(example);
	}

	@Override
	public void delete(Integer cid) {
		// TODO Auto-generated method stub
		goodscartsMapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int updateGoodscarts(Goodscarts goodscarts) {
		// TODO Auto-generated method stub
		return goodscartsMapper.updateByPrimaryKeySelective(goodscarts);
	}

//	@Autowired
//	private GoodscartsMapper goodscartsMapper;
//
//	@Override
//	public void addGoodsCarts(Goodscarts goodscarts) {
//		// TODO Auto-generated method stub
//		GoodscartsExample example=new GoodscartsExample();
//		example.createCriteria().andGIdEqualTo(goodscarts.getgId()).andUIdEqualTo(goodscarts.getuId());
//		List<Goodscarts> list=goodscartsMapper.selectByExample(example);
//		if (list.size()>0) {
//			Goodscarts goodscarts2=list.get(0);
//			goodscarts2.setcNumber(goodscarts2.getcNumber()+goodscarts.getcNumber());
//			goodscartsMapper.updateByPrimaryKeySelective(goodscarts2);
//		}else {
//			goodscartsMapper.insertSelective(goodscarts);
//		}
//	}
//
//	@Override
//	public List<Goodscarts> getGoodsCartsByUid(Integer uid) {
//		// TODO Auto-generated method stub
//		GoodscartsExample example=new GoodscartsExample();
//		example.createCriteria().andUIdEqualTo(uid);
//		example.setOrderByClause("c_id DESC");
////		return goodscartsMapper.selectWithGoodsByExample(example);
//		return null;
//	}
//
//	@Override
//	public void delete(Integer cid) {
//		// TODO Auto-generated method stub
//		goodscartsMapper.deleteByPrimaryKey(cid);
//	}
//
//	@Override
//	public int updateGoodscarts(Goodscarts goodscarts) {
//		// TODO Auto-generated method stub
//		return goodscartsMapper.updateByPrimaryKeySelective(goodscarts);
//	}
	
}
