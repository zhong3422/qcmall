package com.service;

import java.util.List;

import com.bean.Address;

public interface AddressService {

	List<Address> getUsersAddress(Integer uId);

	void addAddress(Address address);

	boolean updateAddress(Address address);

	boolean delAddress(Address address);

}
