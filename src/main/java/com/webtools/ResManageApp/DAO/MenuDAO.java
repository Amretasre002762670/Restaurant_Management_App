package com.webtools.ResManageApp.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Menu;

@Component
public class MenuDAO extends DAO {


	    public void addMenu(Menu menu) {
	        try {
	            begin();
	            getSession().save(menu);
	            commit();
	            close();
	        } catch (Exception E) {
	            System.out.println(E);
	        }
	    }
	    
	    public Menu getMenu(int menuId) {
	    	Menu menuList = null;
	    	
	    	try {
	    		begin();
	    		Query q = getSession().createQuery("from Menu where menuId = :menuId");
	    		q.setInteger("menuId", menuId);
	    		menuList = (Menu) q.uniqueResult();
	    		commit();
	    		close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		rollback();
	    	}
	    	
	    	return menuList;
	    }
}
