package com.webtools.ResManageApp.controller;

import com.webtools.ResManageApp.DAO.CustomerDAO;
//import com.webtools.ResManageApp.DAO.UserDAO;
import com.webtools.ResManageApp.pojo.Customer;
//import com.webtools.ResManageApp.pojo.User;
import com.webtools.ResManageApp.validator.CustomerLoginValidator;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Component
@Controller
public class LoginCustomerController {
	
	@Autowired
	private CustomerLoginValidator cusVali;

    public LoginCustomerController() {
    }

    @GetMapping("/logincustomer.htm")
    protected String handleGetLogin(
    		HttpServletRequest request,
            ModelMap model, Customer customer) throws Exception {
        model.addAttribute("customer", customer);
        return "login-customer";
    }

    @PostMapping("/logincustomer.htm")
    public ModelAndView handlePostLogin(HttpServletRequest request, CustomerDAO customerdao, @ModelAttribute("customer") Customer cutomer, BindingResult cusResult) {
        ModelAndView model = null;
        try {
        	
        	cusVali.validate(cutomer, cusResult);
        	if (cusResult.hasErrors() ) {
        		return new ModelAndView("login-customer");
        	}
        	
            Customer loggedin = customerdao.getCustomer(cutomer.getCustomer_name(), cutomer.getPassword());
            
            HttpSession session = request.getSession();
            if (loggedin != null && session != null) {
            	session.setAttribute("customer", loggedin);
            	model = new ModelAndView("customer-landing");
            } 
            else if (loggedin == null) {            	
                model = new ModelAndView("error-page");
            }

        } catch (Exception e) {
        	model = new ModelAndView("error-page");
            System.out.println(e);
        }
        return model;
    }

}

