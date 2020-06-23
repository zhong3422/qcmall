package com.bean;

import java.util.List;

public class GoodsSaleAttr {
    private Integer id;

    private Integer spuId;

    private Integer saleAttrId;
    
    private SaleAttr saleAttr;
    
    private List<GoodsSaleAttrValue> goodsSaleAttrValues;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(Integer saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

	public SaleAttr getSaleAttr() {
		return saleAttr;
	}

	public void setSaleAttr(SaleAttr saleAttr) {
		this.saleAttr = saleAttr;
	}

	public List<GoodsSaleAttrValue> getGoodsSaleAttrValues() {
		return goodsSaleAttrValues;
	}

	public void setGoodsSaleAttrValues(List<GoodsSaleAttrValue> goodsSaleAttrValues) {
		this.goodsSaleAttrValues = goodsSaleAttrValues;
	}

	@Override
	public String toString() {
		return "GoodsSaleAttr [id=" + id + ", spuId=" + spuId + ", saleAttrId=" + saleAttrId + ", saleAttr=" + saleAttr
				+ "]";
	}
	
	
	
}