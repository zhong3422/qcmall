package com.bean;

public class GoodsSkuSaleAttrValue {
    private Integer id;

    private Integer skuId;

    private Integer saleAttrId;

    private Integer valueId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(Integer saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

	@Override
	public String toString() {
		return "GoodsSkuSaleAttrValue [id=" + id + ", skuId=" + skuId + ", saleAttrId=" + saleAttrId + ", valueId="
				+ valueId + "]";
	}
    
    
    
}