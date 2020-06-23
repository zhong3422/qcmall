package com.bean;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;

    private Integer uId;

    private String statu;

    private String address;

    private String addressee;

    private String phonenumber;

    private Date creationtime;

    private Date deliverytime;

    private Date completiontime;
    
    private List<Orderitems> orderitems;

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

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu == null ? null : statu.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee == null ? null : addressee.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Date getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(Date deliverytime) {
        this.deliverytime = deliverytime;
    }

    public Date getCompletiontime() {
        return completiontime;
    }

    public void setCompletiontime(Date completiontime) {
        this.completiontime = completiontime;
    }

	public List<Orderitems> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<Orderitems> orderitems) {
		this.orderitems = orderitems;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", uId=" + uId + ", statu=" + statu + ", address=" + address + ", addressee="
				+ addressee + ", phonenumber=" + phonenumber + ", creationtime=" + creationtime + ", deliverytime="
				+ deliverytime + ", completiontime=" + completiontime + "]";
	}
	
	
	
	
	
}