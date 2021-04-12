package com.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.ShippingAddress;

import com.adminportal.repository.ShippingAddressRepository;
import com.adminportal.service.ShippingAddressService;

@Service
public class ShippingAddressImpl implements ShippingAddressService {

@Autowired
private ShippingAddressRepository shippingAddressRepository;

	    
	    
	public List<ShippingAddress> findAll() {
	    return (List<ShippingAddress>) shippingAddressRepository.findAll();
}
}
