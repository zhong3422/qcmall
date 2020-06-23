package com.service;

import java.util.List;

import com.bean.Goodscarts;

public interface GoodscartsService {

	void addGoodsCarts(Goodscarts goodscarts);

	List<Goodscarts> getGoodsCartsByUid(Integer uid);

	void delete(Integer cid);

	int updateGoodscarts(Goodscarts goodscarts);

}
