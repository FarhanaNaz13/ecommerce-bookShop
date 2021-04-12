package com.adminportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adminportal.domain.ShippingAddress;
import com.adminportal.service.ShippingAddressService;

@Controller
@RequestMapping("/shipping")

public class ShippingAddressController {

@Autowired
private ShippingAddressService shippingAddressService;
	
 
@RequestMapping("/shippingList")
 
 public String shippingList(Model model) {
	        List<ShippingAddress> shippinglist = shippingAddressService.findAll();
	        model.addAttribute("shippingList", shippinglist);

	        return "shippingList";
	    }
}
