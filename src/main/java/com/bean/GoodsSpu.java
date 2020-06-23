package com.bean;

import java.util.List;

public class GoodsSpu {
    private Integer id;

    private String name;

    private Integer catalog2Id;

    private Integer salesvolume;

    private Double price;

    private String description;

    private String image;
    
    private List<GoodsSaleAttr> goodsSaleAttrs;
    
    private List<GoodsImages> goodsImages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(Integer catalog2Id) {
        this.catalog2Id = catalog2Id;
    }

    public Integer getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Integer salesvolume) {
        this.salesvolume = salesvolume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

	public List<GoodsSaleAttr> getGoodsSaleAttrs() {
		return goodsSaleAttrs;
	}

	public void setGoodsSaleAttrs(List<GoodsSaleAttr> goodsSaleAttrs) {
		this.goodsSaleAttrs = goodsSaleAttrs;
	}

	@Override
	public String toString() {
		return "GoodsSpu [id=" + id + ", name=" + name + ", catalog2Id=" + catalog2Id + ", salesvolume=" + salesvolume
				+ ", price=" + price + ", description=" + description + ", image=" + image + "]";
	}

	public List<GoodsImages> getGoodsImages() {
		return goodsImages;
	}

	public void setGoodsImages(List<GoodsImages> goodsImages) {
		this.goodsImages = goodsImages;
	}
	
	
	
}