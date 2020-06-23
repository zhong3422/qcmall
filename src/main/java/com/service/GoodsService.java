package com.service;

import java.util.List;

//import com.bean.Goods;
import com.bean.GoodsSpu;

public interface GoodsService {

//	int releaseGoods(Goods goods);
//
//	List<Goods> getGoodsList();
//
//	int updateGoods(Goods goods);
//
//	Goods getGoodsDetails(Integer gid);
//
//	List<Goods> Seachgoods(String keyword);
//
//	List<Goods> getGoodsListOrderBygSalesvolume();

	GoodsSpu getGoodsBySpu(Integer gid);

	

}
