package com.bean;

public class Orderitems {
    private Integer id;

    private Integer oId;

    private Integer skuId;

    private Double price;

    private Integer number;

    private String express;
    
    private GoodsSku goodsSku;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express == null ? null : express.trim();
    }

	public GoodsSku getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(GoodsSku goodsSku) {
		this.goodsSku = goodsSku;
	}

	@Override
	public String toString() {
		return "Orderitems [id=" + id + ", oId=" + oId + ", skuId=" + skuId + ", price=" + price + ", number=" + number
				+ ", express=" + express + ", goodsSku=" + goodsSku + "]";
	}
	
	
	
}