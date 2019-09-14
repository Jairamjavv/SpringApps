package com.sma.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sma.beans.CustomerBean;
import com.sma.service.CustomerService;
import com.sma.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	@Autowired
	public CustomerServiceImpl customerService;
	
	@RequestMapping(value="/addCustomer")
	public ModelAndView loadCustomerForm() {
		ModelAndView mav = new ModelAndView("CreateCustomer");
		mav.addObject("customerBean", new CustomerBean());
		return mav;
	}
	
	@RequestMapping(value="/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerBean")CustomerBean customBean) {
		Integer id=0;
		try {
			id = customerService.addCustomer(customBean);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		ModelAndView mav = new ModelAndView("CreateCustomerSuccess");
		mav.addObject("cid", "Customer added successfully with id:"+id);
		return mav;
	}
	
	public Map<String, String> populateCustomerType() {
		
		return null;
	}
	
	public ModelAndView handleAllException(Exception exception) {
		return null;
	}
	
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
