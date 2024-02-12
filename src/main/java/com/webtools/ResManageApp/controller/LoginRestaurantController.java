package com.webtools.ResManageApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webtools.ResManageApp.DAO.CustomerDAO;
import com.webtools.ResManageApp.DAO.RestaurantDAO;
import com.webtools.ResManageApp.DAO.UserDAO;
import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Restaurant;
import com.webtools.ResManageApp.validator.RestaurantLoginValidator;
import com.webtools.ResManageApp.validator.RestaurantValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
@Controller
public class LoginRestaurantController {
	
	@Autowired
	private RestaurantLoginValidator resVali;
	
	@GetMapping("/loginrestaurant.htm")
	public String handleLoginGet(UserDAO userdao, ModelMap model, Restaurant res, HttpServletRequest req) {
		model.addAttribute("restaurant", res);
		return "login-restaurant";
	}

	@PostMapping("/loginrestaurant.htm")
	public ModelAndView handlePostLogin(HttpServletRequest request, RestaurantDAO restaurantdao,
			@ModelAttribute("restaurant") Restaurant res, BindingResult resResult) {
		ModelAndView model = null;
		try {
			
			resVali.validate(res, resResult);
        	if (resResult.hasErrors()) {
        		return new ModelAndView("login-restaurant");
        	}
        	
			Restaurant loggedin = restaurantdao.getRestaurantAdmin(res.getRes_name(), res.getPassword());
	        		HttpSession session = request.getSession();
	            
			if (loggedin != null) {
				session.setAttribute("res", loggedin);
				model = new ModelAndView("res-landing");
			} else if (loggedin == null) {
				model = new ModelAndView("error-page");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			model = new ModelAndView("error-page");
		}
		return model;
	}
	
	@GetMapping("/logoutrestaurant")
    public String logout(HttpSession session) {
        session.removeAttribute("res"); 
        session.invalidate();
        return "logout-success"; 
    }
}
