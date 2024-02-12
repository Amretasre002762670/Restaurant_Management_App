package com.webtools.ResManageApp.DAO;

import java.util.List;

import org.hibernate.query.Query;

import com.webtools.ResManageApp.pojo.Address;
import com.webtools.ResManageApp.pojo.Restaurant;
import com.webtools.ResManageApp.pojo.User;


public class AddressDAO extends DAO {
	 public void addAddress(Address address) {
	        try {
	            begin();
	            getSession().save(address);
	            commit();
	        } catch (Exception E) {
	            System.out.println(E);
	        }
	    }
	 
	 public int getAddressId(Address address) {
		 int add_id = 0;
	        boolean isUserExist = false;
	        try {
	            Query q = getSession().createQuery("from Address where addr_id= :id");
	            q.setFloat("id", address.getAddrId());
	         
	            Address addr = (Address) q.uniqueResult();
	            add_id = addr.getAddrId();
//	            if(user != null) {
//	                isUserExist = true;
//	            } else {
//	                isUserExist = false;
//	            }
	            System.out.println(add_id + " in DAO");
//	        User user = getSession().get(User.class, userid);
	        } catch (Exception E) {
	            
	            System.out.println(E);
	        }
	        return add_id;
	 }
	 
	 public List<Address> searchAddresstCity(String city) {
	    	List<Address> add_list = null;
	    	try {
	    		begin();
	    		Query q = getSession().createQuery("from Adress where city= :city");
	            q.setString("city", city);
	            add_list = q.list();
	            commit();
	            close();
	         // Check if res_list is not empty before accessing its elements
	            if (!add_list.isEmpty()) {
	                System.out.println(add_list.get(0).getAddrId());
	            }
	            
	    	} catch (Exception e) {
	    		rollback();
	    		e.printStackTrace();
	    		
	    	}
	    	return add_list;
	    }
	 
	 public List<Address> searchAddressStreet(String street) {
	    	List<Address> add_list = null;
	    	try {
	    		begin();
	    		Query q = getSession().createQuery("from Adress where streetName= :streetName");
	            q.setString("streetName", street);
	            add_list = q.list();
	            commit();
	            close();
	    	} catch (Exception e) {
	    		rollback();
	    	}
	    	return add_list;
	    }
}
