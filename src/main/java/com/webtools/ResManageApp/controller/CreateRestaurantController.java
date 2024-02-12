package com.webtools.ResManageApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webtools.ResManageApp.DAO.AddressDAO;
import com.webtools.ResManageApp.DAO.CustomerDAO;
import com.webtools.ResManageApp.DAO.RestaurantDAO;
import com.webtools.ResManageApp.DAO.UserDAO;
import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Restaurant;
import com.webtools.ResManageApp.validator.AddressValidator;
import com.webtools.ResManageApp.validator.RestaurantValidator;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Controller
public class CreateRestaurantController {
	
	@Autowired
	private RestaurantValidator resVali;
	
	
	@GetMapping("/createrestaurant.htm")
    public String handleLoginGet(UserDAO userdao, ModelMap model, Restaurant res) {
        model.addAttribute("restaurant", res);
        return "create-restaurant";
    }

    @PostMapping("/createrestaurant.htm")
    protected String handleCreateUser(HttpServletRequest request, RestaurantDAO restaurantdao, AddressDAO addressdao, @ModelAttribute("restaurant") Restaurant restaurant,  BindingResult resResult) throws Exception {
        try {
        	
        	resVali.validate(restaurant, resResult);
        	if (resResult.hasErrors()) {
        		
        		return "create-restaurant";
        	}
        	
        	addressdao.addAddress(restaurant.getAddress());
        	restaurantdao.addRestaurantWithAddress(restaurant);

        } catch (Exception e) {
        	e.printStackTrace();
        	return "error-page";
        	
        }

        return "create-success";
    }

}
