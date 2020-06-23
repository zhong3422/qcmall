package com.bean;

import java.util.List;

public class GoodsSku {
    private Integer id;

    private Integer spuId;

    private String name;

    private Double price;

    private Integer inventory;

    private String image;

    private Integer salesvolume;
    
    private GoodsSpu goodsSpu;
    
    private List<GoodsSkuSaleAttrValue> goodsSkuSaleAttrValues;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Integer salesvolume) {
        this.salesvolume = salesvolume;
    }

	@Override
	public String toString() {
		return "GoodsSku [id=" + id + ", spuId=" + spuId + ", name=" + name + ", price=" + price + ", inventory="
				+ inventory + ", image=" + image + ", salesvolume=" + salesvolume + "]";
	}

	public List<GoodsSkuSaleAttrValue> getGoodsSkuSaleAttrValues() {
		return goodsSkuSaleAttrValues;
	}

	public void setGoodsSkuSaleAttrValues(List<GoodsSkuSaleAttrValue> goodsSkuSaleAttrValues) {
		this.goodsSkuSaleAttrValues = goodsSkuSaleAttrValues;
	}

	public GoodsSpu getGoodsSpu() {
		return goodsSpu;
	}

	public void setGoodsSpu(GoodsSpu goodsSpu) {
		this.goodsSpu = goodsSpu;
	}
    
    
    
}