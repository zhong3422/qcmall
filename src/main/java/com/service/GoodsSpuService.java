package com.service;

import java.util.List;

import com.bean.GoodsSpu;

public interface GoodsSpuService {

	int addSpu(GoodsSpu goodsSpu);

	void updateSpu(GoodsSpu goodsSpu);

	List<GoodsSpu> getSpuList();

	List<GoodsSpu> keywordsSearch(String keyword);

	List<GoodsSpu> searchSpu(String keyword);

}
