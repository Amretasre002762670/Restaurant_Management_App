package com.webtools.ResManageApp.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webtools.ResManageApp.DAO.OrderDAO;
import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Menu;
import com.webtools.ResManageApp.pojo.Orders;
import com.webtools.ResManageApp.pojo.Restaurant;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Component
@Controller
@Transactional
public class RestaurantController {
	
	@Autowired
	OrderDAO orderDao;

	
	@GetMapping("/vieworder.htm")
	public ModelAndView handleViewOrderGet(HttpServletRequest req) {
		ModelAndView orderListPage = null;
		HttpSession session = req.getSession();
		List<Orders> orderHistory = null;
		
		try {
			Restaurant restaurant = (Restaurant) session.getAttribute("res");
			int res_id = restaurant.getRes_id();
			
			
			
//			orderHistory = orderDao.getRestaurantOrderList(res_id);
			
			orderHistory = orderDao.getRestaurantOrderList(res_id);
//		    for (Orders order : orderHistory) {
//		        Hibernate.initialize(order.getOrderedMenu());
//		    }
			
			if(orderHistory == null || orderHistory.size() < 0) {
				orderListPage = new ModelAndView("error-page");
			} else {
				orderListPage = new ModelAndView("restaurant-order-history");
				session.setAttribute("orders", orderHistory);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			orderListPage= new ModelAndView("error-page");
		}
		
		return orderListPage;
	}
	
	@Transactional
	@PostMapping("/viewordermenu.htm")
	public ModelAndView handleViewOrderMenuPost(HttpServletRequest req) {
		ModelAndView viewOrderMenu = null;
		HttpSession session = req.getSession();
		List<Orders> orderHistory  = (List<Orders>) session.getAttribute("orders");
//		for (Orders order : orderHistory) {
//	        Hibernate.initialize(order.getOrderedMenu());
//	    }
		String currentStatus = null;
		long orderId = Long.parseLong(req.getParameter("view-menu"));
		System.out.println(orderId);
		
		try {
			
			for (Orders order: orderHistory) {
				if(order.getOrderId() == orderId) {
					currentStatus = order.getStatus();
					session.setAttribute("currentOrder", order);
				}
			}
			
			session.setAttribute("currentStatus", currentStatus);
			
			List<Menu> menuList = orderDao.getMenuFromOrder(orderId);
			
			if(menuList.size() > 0) {
				req.setAttribute("menuList", menuList);
				viewOrderMenu = new ModelAndView("restaurant-order-menu");
			} else {
				viewOrderMenu = new ModelAndView("error-page");
			}
			
		} catch (Exception e) {
			viewOrderMenu = new ModelAndView("error-page");
			e.printStackTrace();
		}
		return viewOrderMenu;		
	}
	
	@PostMapping("/changestatus.htm")
	public String handleChangeStatusPost(HttpServletRequest req) {
		HttpSession session = req.getSession();
		try {
			String orderStatusChanged = (String) req.getParameter("order-status");
			System.out.println(orderStatusChanged + " status from request");
			if(orderStatusChanged != null ) {
				Orders order = (Orders) session.getAttribute("currentOrder");
				order.setStatus(orderStatusChanged);
				orderDao.updateOrderStatus(order);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";
		}
		
		
		return "success-status-change";
	}
}
