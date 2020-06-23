package com.bean;

public class GoodsImages {
    private Integer id;

    private Integer gId;

    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

	@Override
	public String toString() {
		return "GoodsImages [id=" + id + ", gId=" + gId + ", path=" + path + "]";
	}
    
    
    
}