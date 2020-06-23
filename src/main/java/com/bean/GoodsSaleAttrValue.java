package com.bean;

public class GoodsSaleAttrValue {
    private Integer id;

    private Integer spuId;

    private Integer saleAttrId;

    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

	@Override
	public String toString() {
		return "GoodsSaleAttrValue [id=" + id + ", spuId=" + spuId + ", saleAttrId=" + saleAttrId + ", value=" + value
				+ "]";
	}
    
    
    
}