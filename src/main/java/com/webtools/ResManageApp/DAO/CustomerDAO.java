package com.webtools.ResManageApp.DAO;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Orders;
import com.webtools.ResManageApp.pojo.User;

@Component
public class CustomerDAO extends DAO {

    public Customer getCustomer(String username, String password) {
        Customer cus = null;
//        boolean isUserExist = false;
        try {
            Query q = getSession().createQuery("from Customer where customer_name= :username and Password= :password");
            q.setString("username", username);
            q.setString("password", password);
            cus = (Customer) q.uniqueResult();
//            if(user != null) {
//                isUserExist = true;
//            } else {
//                isUserExist = false;
//            }
            System.out.println(cus.getCustomer_name() + " in DAO");
//        User user = getSession().get(User.class, userid);
        } catch (Exception E) {
            
            System.out.println(E);
        }
        return cus;

    }

    public void addCustomer(Customer customer) {
        try {
            begin();
            getSession().save(customer);
            commit();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
    
    public void addOrderToCustomer(Orders order) {
	 	   
    	try {
    		
    		begin();
    		getSession().merge(order);
    		commit();
    		getSession().evict(order);
            close();
    	} catch (Exception E) {
    		rollback();
            E.printStackTrace();
        }
    }
}
