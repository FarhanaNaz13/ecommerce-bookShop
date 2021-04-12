package com.adminportal.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Order;
import com.adminportal.repository.OrderRepository;
import com.adminportal.service.OrderService;


import java.util.List;

@Service
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    
    
public List<Order> findAll() {
    return (List<Order>) orderRepository.findAll();
}

public Order findOne(Long id) {
    return orderRepository.findById(id).get();
}

public void removeOne(Long id) {
	orderRepository.deleteById(id);
}
}
