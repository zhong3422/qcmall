package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Address;
import com.bean.Users;
import com.service.AddressService;
import com.service.UsersService;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "address",method = RequestMethod.GET)
	public String getAllAddress(HttpServletRequest request,Model model) {
		Users users=(Users) request.getSession().getAttribute("users");
		List<Address> list=addressService.getUsersAddress(users.getId());
		model.addAttribute("address", list);
		
		return "users/addresslist";
	}
	
	
	@RequestMapping(value = "address",method = RequestMethod.POST)
	@ResponseBody
	public boolean addAddress(Address address,HttpServletRequest request,String province,String city,String county) {
		Users users=(Users) request.getSession().getAttribute("users");
		address.setuId(users.getId());
		address.setAddress(province+city+county+address.getAddress());
		addressService.addAddress(address);
		return true;
	}
	
	@RequestMapping("updateAddress")
	@ResponseBody
	public boolean updateAddress(Address address) {
		return addressService.updateAddress(address);
	}
	
	@RequestMapping("delAddress")
	@ResponseBody
	public boolean delAddress(Address address) {
		return addressService.delAddress(address);
	}
	
	@RequestMapping("setDefaultAddress")
	@ResponseBody
	public boolean setDefaultAddress(Address address,HttpServletRequest request) {
		Users users=(Users) request.getSession().getAttribute("users");
		users.setDefaultaddress(address.getId());
		usersService.updateUsers(users);
		return true;
	}
	
}
