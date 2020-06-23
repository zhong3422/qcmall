package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Address;
import com.bean.AddressExample;
import com.dao.AddressMapper;
import com.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public List<Address> getUsersAddress(Integer uId) {
		// TODO Auto-generated method stub
		AddressExample addressExample=new AddressExample();
		addressExample.createCriteria().andUIdEqualTo(uId);
		return addressMapper.selectByExample(addressExample);
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		addressMapper.insertSelective(address);
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		System.out.println(address);
		return addressMapper.updateByPrimaryKeySelective(address)>0;
	}

	@Override
	public boolean delAddress(Address address) {
		// TODO Auto-generated method stub
		return addressMapper.deleteByPrimaryKey(address.getId())>0;
	}

}
