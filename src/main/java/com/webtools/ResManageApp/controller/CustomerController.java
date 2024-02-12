package com.webtools.ResManageApp.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;

import com.webtools.ResManageApp.DAO.CustomerDAO;
import com.webtools.ResManageApp.DAO.OrderDAO;
import com.webtools.ResManageApp.DAO.RestaurantDAO;
import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Menu;
import com.webtools.ResManageApp.pojo.Restaurant;
import com.webtools.ResManageApp.pojo.Orders;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
@Controller
@Transactional
public class CustomerController {
	
	@Autowired
	RestaurantDAO resDao;
	
	@Autowired
	CustomerDAO cusDao;
	
	@Autowired
	OrderDAO orderDao;
	
	
	@GetMapping("/searchrestaurant.htm") 
	public String handleSearchResGet(ModelMap model, Restaurant res){
		model.addAttribute("res", res);
		return "search-restaurant";
	}
	
	@PostMapping("/searchrestaurant.htm")
	public ModelAndView handleSearchResPost(HttpServletRequest req) {
		ModelAndView search = null;
		HttpSession session = req.getSession();
		String searchText = req.getParameter("search-text");
		String searchType = req.getParameter("search-type");
		List<Restaurant> resList = null;
		try {
			if(searchType.equalsIgnoreCase("res-name")) {
				resList = resDao.searchRestaurantName(searchText);
			} 
//			else if (searchType.equalsIgnoreCase("res-city")) {
//				resList = resDao.searchRestaurantCity(searchText);
//			} else if (searchType.equalsIgnoreCase("res-street")) {
//				resList = resDao.searchRestaurantStreet(searchText);
//			}
			
			
			if (resList != null || resList.size() > 0) {
				session.setAttribute("res-list", resList);
				search = new ModelAndView("list-restaurant");
			} else {
				search = new ModelAndView("error-restaurant-list");
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 search = new ModelAndView("error-restaurant-list");
		}
		
	
		return search;
	}
	
	@Transactional
	@PostMapping("/listmenu.htm")
	public ModelAndView handlerListMenuPost(HttpServletRequest req) {
		ModelAndView menu = null;
		List<Menu> menuList = null;
		HttpSession session = req.getSession();
		List<Restaurant> resList = (List<Restaurant>) session.getAttribute("res-list");
		
		try {
			int resId = Integer.parseInt(req.getParameter("res_id"));
			
			Restaurant restaurant = resDao.getRestaurantById(resId);
			menuList = restaurant.getRes_menu_list();
			session.setAttribute("res", restaurant);
			
			if(menuList != null && menuList.size() > 0) {
				session.setAttribute("menuList", menuList);
				menu = new ModelAndView("view-menu");
			} else {
				menu = new ModelAndView("error-page");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			menu = new ModelAndView("error-page");
		}
		
		return menu;
		
	}
	
	@PostMapping("/listcart.htm")
	public ModelAndView handleViewCartPost(HttpServletRequest req) {
		
		ModelAndView cart = null;
		HttpSession session = req.getSession();
		List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
		String[] menuNames = req.getParameterValues("cart_items");
		Restaurant res = (Restaurant) session.getAttribute("res");
		List<Menu> cartList = new ArrayList<>();
		float totalPrice = 0;
		try {
			for(Menu menu: menuList) {
				for(int i = 0; i < menuNames.length; i++) {
					if(menu.getMenu_name().equalsIgnoreCase(menuNames[i])) {
						cartList.add(menu);
						totalPrice = totalPrice + menu.getMenu_price();
					}
				}
			}
			
			System.out.println(cartList.size()+ " cart items");
			
			if(cartList != null && cartList.size() > 0) {
				session.setAttribute("cart", cartList);
				session.setAttribute("res", res);
				req.setAttribute("total", totalPrice);
				cart = new ModelAndView("view-cart");
			} else if (cartList.size() == 0) {
				cart = new ModelAndView("cart-empty");
			} else {
				cart =  new ModelAndView("error-page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			cart =  new ModelAndView("error-page");
		}
		
		
		return cart;
	}
	
	@PostMapping("/viewcart.htm")
	public ModelAndView handlViewCartPost(HttpServletRequest req) {
		HttpSession session = req.getSession();
		ModelAndView placeOrder = null;
		try {
			Customer customer = (Customer) session.getAttribute("customer");
			Restaurant restaurant = (Restaurant) session.getAttribute("res");
			List<Menu> cartList = (List<Menu>) session.getAttribute("cart");
			Orders newOrder = new Orders();
			
			if (cartList != null && cartList.size() > 0 & customer != null && restaurant!= null) {
				newOrder.setStatus("order placed");
				for (Menu menu: cartList) {
					newOrder.getOrderedMenu().add(menu);
				}
				
				newOrder.setCustomer(customer);
				newOrder.setRestaurant(restaurant);
				newOrder.setUuid(UUID.randomUUID().toString());
				
				orderDao.addOrders(newOrder);
				placeOrder = new ModelAndView("order-successful");
			} else {
				placeOrder = new ModelAndView("error-page");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			placeOrder = new ModelAndView("error-page");
		}
		return placeOrder;
	}
	
	@GetMapping("/orderhistory.htm") 
	public ModelAndView handleViewOrderGet(HttpServletRequest req){
		
		HttpSession session = req.getSession();
		List<Orders> orderHistory = null;
		
		try {
			Customer customer = (Customer) session.getAttribute("customer");
			System.out.println(customer.getCustomer_id());
			int cust_id = customer.getCustomer_id();
			
			orderHistory = orderDao.getCustomerOrderList(cust_id);
			System.out.println(orderHistory.size());
			session.setAttribute("orders", orderHistory);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error-page");
		}
		
		return new ModelAndView("customer-order-history");
	}
	
}
