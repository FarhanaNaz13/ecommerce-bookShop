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
import com.adminportal.domain.ShippingAddress;
import com.adminportal.domain.User;
import com.adminportal.service.OrderService;
import com.adminportal.service.ShippingAddressService;
import com.adminportal.service.UserService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/user")
public class UserController {

	 @Autowired
	    private UserService userService;
	  
	
	 @RequestMapping("/userList")
	    public String userList(Model model) {
	        List<User> userList = userService.findAll();
	        model.addAttribute("userList", userList);

	        return "userList";
	    }
	
	 @RequestMapping(value="/remove", method=RequestMethod.POST)
	    public String remove(
	            @ModelAttribute("id") String id, Model model
	    ) {
		 userService.removeOne(Long.parseLong(id.substring(8)));
	        List<User> userlist = userService.findAll();
	        model.addAttribute("userList", userlist);

	        return "redirect:/user/userList";
	    }
	 

	 		
	 	
}
