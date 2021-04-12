package com.adminportal.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.adminportal.domain.Order;
import com.adminportal.service.OrderService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/order")
public class OrderController {

	 @Autowired
	    private OrderService orderService;	
	
	 @RequestMapping("/orderList")
	    public String orderList(Model model) {
	        List<Order> orderList = orderService.findAll();
	        model.addAttribute("orderList", orderList);

	        return "orderList";
	    }
	 @GetMapping("/export/{format}")
	 private String exportReport(@PathVariable String format) throws FileNotFoundException, JRException {
		 return orderService.exportReport(format);
	 }
	 
	 @RequestMapping(value="/remove", method=RequestMethod.POST)
	    public String remove(
	            @ModelAttribute("id") String id, Model model
	    ) {
	        orderService.removeOne(Long.parseLong(id.substring(8)));
	        List<Order> orderList = orderService.findAll();
	        model.addAttribute("orderList", orderList);

	        return "redirect:/order/orderList";
	    }
}
