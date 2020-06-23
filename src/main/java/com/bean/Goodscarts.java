package com.bean;

public class Goodscarts {
    private Integer id;

    private Integer uId;

    private Integer skuId;

    private Integer number;
    
    private GoodsSku goodsSku;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

	@Override
	public String toString() {
		return "Goodscarts [id=" + id + ", uId=" + uId + ", skuId=" + skuId + ", number=" + number + "]";
	}

	public GoodsSku getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(GoodsSku goodsSku) {
		this.goodsSku = goodsSku;
	}
    
    
    
}