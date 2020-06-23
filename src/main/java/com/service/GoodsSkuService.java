package com.service;

import java.util.List;

import com.bean.GoodsSku;

public interface GoodsSkuService {

	List<GoodsSku> getSkuWithVidBySkuId(Integer gid);

	GoodsSku getSkuById(Integer id);

	int addSku(GoodsSku goodsSku);

	void updateGoodsSku(GoodsSku goodsSku);

}
