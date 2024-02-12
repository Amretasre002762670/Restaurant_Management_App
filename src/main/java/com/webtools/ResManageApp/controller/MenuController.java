package com.webtools.ResManageApp.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webtools.ResManageApp.DAO.MenuDAO;
import com.webtools.ResManageApp.DAO.RestaurantDAO;
import com.webtools.ResManageApp.DAO.UserDAO;
import com.webtools.ResManageApp.pojo.Menu;
import com.webtools.ResManageApp.pojo.Restaurant;
import com.webtools.ResManageApp.validator.AddressValidator;
import com.webtools.ResManageApp.validator.MenuValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
@Controller
@Transactional
public class MenuController {
	public MenuController() {
		
	}
	@Autowired
	private MenuDAO menudao;
	
	@Autowired
	private RestaurantDAO resDao;
	
	@Autowired
	private MenuValidator menuVali;
	
	@GetMapping("/addmenu.htm")
	public String handleCreateMenuGet(ModelMap model, Menu menu, HttpServletRequest request) {
		model.addAttribute(menu);
		return "create-menu";
	}
	
	@PostMapping("/addmenu.htm")
	public String handleCreateMenuPost(MenuDAO menudao, ModelMap model,  @ModelAttribute("menu") Menu menu, HttpServletRequest request, BindingResult result) {
		HttpSession session = request.getSession();
		try {
			
			Restaurant res = (Restaurant) session.getAttribute("res");
			List<Menu> res_menu = res.getRes_menu_list();
			
			menuVali.validate(menu, result);
//        	addVali.validate(restaurant.getAddress(), addResult);
        	if (result.hasErrors()) {
        		return "create-menu";
        	}       	
        	    res_menu.add(menu);
        	    
//        	    menudao.addMenu(menu);
        	    resDao.addMenuToRestaurant(res);
        	
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
		return "menu-success";
	}
	
	@GetMapping("/viewmenu.htm")  
	public ModelAndView handleViewMenuGet(HttpServletRequest request) {
		ModelAndView viewMenu = null;
		try {
			Restaurant res = (Restaurant) request.getSession().getAttribute("res");
			viewMenu = new ModelAndView("view-menu-restaurant", "res", res);
		} catch (Exception e) {
			
			viewMenu = new ModelAndView("error-page");
			System.out.println(e);
		}
		return viewMenu;
	}
	
//	@PostMapping("/viewmenu.htm")
//	public ModelAndView handleViewMenuPost(HttpServletRequest request) {
//		ModelAndView success = null;
////		HttpSession session = request.getSession();
//		try {
//			Restaurant res = (Restaurant) request.getSession().getAttribute("res");
//			
//		} catch (Exception E) {
//			System.out.println(E);
//		}
//		return success;
//	}
}
