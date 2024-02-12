package com.webtools.ResManageApp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TableGenerator;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.webtools.ResManageApp.pojo.Menu;
import com.webtools.ResManageApp.pojo.Orders;
import com.webtools.ResManageApp.pojo.Restaurant;

import org.hibernate.Hibernate;
import org.hibernate.Session;


@Component
public class OrderDAO extends DAO {
	
	@PersistenceContext
    private EntityManager entityManager;

//    public void saveOrder(Orders order) {
//        TableGenerator tableGenerator = entityManager.unwrap(Session.class).getTableGenerator();
//        order.setId((Long) tableGenerator.generateValue("order_id_generator"));
//        entityManager.persist(order);
//    }
    
	public void addOrders(Orders order) {
        try {
            begin();
            getSession().save(order);
            commit();
            close();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
	
	public List<Orders> getCustomerOrderList(int cust_id) {
        List<Orders> orderList = null;
        try {
        	begin();
            Query q = getSession().createQuery("from Orders where customer_id= :cust_id");
            q.setInteger("cust_id", cust_id);
            orderList = (List<Orders>) q.list();
            System.out.println(orderList.size());
            commit();
            close();
      
        } catch (Exception E) {
        	E.printStackTrace();
        	rollback();
            
        }
        return orderList;

    }
	
	public List<Orders> getRestaurantOrderList(int res_id) {
        List<Orders> orderList = null;
        try {
        	begin();
            Query q = getSession().createQuery("from Orders where restaurant_id= :res_id");
            q.setInteger("res_id", res_id);
            orderList = (List<Orders>) q.list();
            commit();
            close();
      
        } catch (Exception E) {
        	E.printStackTrace();
            rollback();
            
        }
        return orderList;

    }
	
	public List<Menu> getMenuFromOrder(long orderId) {
		List<Menu> menuList = null;
		try {

			
			begin();
	        Query q = getSession().createQuery("from Orders where orderId= :orderId");
	        q.setParameter("orderId", orderId);

	        Orders order = (Orders) q.uniqueResult();

	        if (order != null) {
	            Hibernate.initialize(order.getOrderedMenu());
	            menuList = order.getOrderedMenu();
	        }

	        commit();
	        close();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} 
		
		
		return menuList;
	}
	
	public void updateOrderStatus(Orders order) {
		try {
			begin();
			System.out.println(order.getStatus() + "Status is Order DAO");
			getSession().saveOrUpdate(order);
			commit();
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		} finally {
			close();
		}
	}
}
