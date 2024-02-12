package com.webtools.ResManageApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.validation.BindingResult;

import com.webtools.ResManageApp.DAO.AddressDAO;
import com.webtools.ResManageApp.DAO.CustomerDAO;
import com.webtools.ResManageApp.DAO.UserDAO;
import com.webtools.ResManageApp.pojo.Address;
import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.User;
import com.webtools.ResManageApp.validator.AddressValidator;
import com.webtools.ResManageApp.validator.CustomerValidator;

import jakarta.servlet.http.HttpServletRequest;




@Component
@Controller
public class CreateCustomerController {
	
	@Autowired
	private CustomerValidator cusVali;
	
//	@Autowired
//	private AddressValidator addVali;


    public CreateCustomerController() {
    }

    @GetMapping("/createcustomer.htm")
    public String handleLoginGet(UserDAO userdao, ModelMap model, Customer customer) {
//        User user_db = userdao.getUser(user.getName(), user.getPassword());
        model.addAttribute("Customer", customer);
//        model.addAttribute("address", address);
        return "create-customer";
    }

    @PostMapping("/createcustomer.htm")
    protected String handleCreateUser(HttpServletRequest request, CustomerDAO customerdao, AddressDAO addressdao, @ModelAttribute("customer") Customer customer, BindingResult cusResult) throws Exception {
    	
        try {
        	
        	cusVali.validate(customer, cusResult);
        	if (cusResult.hasErrors() ) {

        		return "create-customer";
        	}

    		addressdao.addAddress(customer.getAddress());
        	customerdao.addCustomer(customer);
        	
        } catch (Exception e) {
         
          e.printStackTrace();
          return "error-page";
         
        }

        return "create-success";
    }

}

