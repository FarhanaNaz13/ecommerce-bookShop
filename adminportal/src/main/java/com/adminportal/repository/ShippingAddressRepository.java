package com.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.domain.ShippingAddress;


public interface ShippingAddressRepository  extends CrudRepository<ShippingAddress, Long> {

}
