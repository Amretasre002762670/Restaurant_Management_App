package com.webtools.ResManageApp.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
    	try {
    		req.getSession().invalidate();
            
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error-page";
    	}
    	return "logout-success";
         
    }
    
}

