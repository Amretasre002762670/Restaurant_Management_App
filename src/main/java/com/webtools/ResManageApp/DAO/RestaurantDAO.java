package com.webtools.ResManageApp.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.webtools.ResManageApp.pojo.Address;
import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Menu;
import com.webtools.ResManageApp.pojo.Orders;
import com.webtools.ResManageApp.pojo.Restaurant;

@Component
public class RestaurantDAO extends DAO {
	 public Restaurant getRestaurantAdmin(String username, String password) {
	        Restaurant res = null;
	        Restaurant restaurant = null;
	        try {
	        	begin();
	            Query q = getSession().createQuery("from Restaurant where res_name= :username and Password= :password");
	            q.setString("username", username);
	            q.setString("password", password);
	            res = (Restaurant) q.uniqueResult();
	            System.out.println(res.getRes_id());
	            Query query = getSession().createQuery("FROM Restaurant r JOIN FETCH r.res_menu_list WHERE r.id = :id");
	        	query.setParameter("id", res.getRes_id());
	        	restaurant = (Restaurant) query.uniqueResult();
	            
	            
//	            Hibernate.initialize(restaurant.getRes_menu_list());
	            commit();
	            close();
	            
	        } catch (Exception E) {
	            
	            System.out.println(E);
	        }
	        return restaurant;

	    }
	 
	 public Restaurant getRestaurantById(int id) {
	        Restaurant restaurant = null;
	        try {
	        	begin();
	        	Query query = getSession().createQuery("FROM Restaurant r JOIN FETCH r.res_menu_list WHERE r.id = :id");
	        	query.setParameter("id", id);
	        	restaurant = (Restaurant) query.uniqueResult();
	        	System.out.println(restaurant.getRes_id() + "inside dao");
//	            Query q = getSession().createQuery("from Restaurant where res_id= :id");
//	            q.setInteger("id", id);
//	            res = (Restaurant) q.uniqueResult();
//	            Hibernate.initialize(res.getRes_menu_list());
	            commit();
	            close();
	            
	        } catch (Exception E) {
	            
	            System.out.println(E);
	        }
	        return restaurant;

	    }

	    public void addRestaurantWithAddress(Restaurant res) {
	        try {
	            begin();
	            getSession().saveOrUpdate(res.getAddress());
	            getSession().saveOrUpdate(res);
	            commit();
	            getSession().evict(res);
	            close();
	        } catch (Exception E) {
	        	rollback();
	            System.out.println(E + " in restaurant dao");
	        }
	    }
	    
	    @Transactional
	    public void addMenuToRestaurant(Restaurant res) {
	   
	    	try {
	    		System.out.println(res.getRes_id());
	    		
//	    		List<Menu> existingMenus = getSession()
//	    			    .createQuery("SELECT m FROM Restaurant r JOIN r.res_menu_list m WHERE r.res_id = :id", Menu.class)
//	    			    .setParameter("id", res.getRes_id())
//	    			    .getResultList();
//	    	        for (Menu menu : res.getRes_menu_list()) {
//	    	        	System.out.println(existingMenus.contains(menu) + " menu exists");
//	    	            if (!existingMenus.contains(menu)) {
//	    	                getSession().save(menu);
//	    	            }
//	    	        }
	    	        getSession().evict(res);
	    	        begin();
	    			getSession().saveOrUpdate(res);
	    			commit();
	    			close();
//	    			System.out.println(res.getRes_menu_list().get(0).getMenu_name() + " menu");
//	    			for (Menu menu : res.getRes_menu_list()) {
//	    	            getSession().save(menu);
//	    	        }
//	    	        getSession().saveOrUpdate(res);
//	    	        commit();
//	    	        getSession().evict(res);
	    		
	    		
	    		
//	    		for (Menu menu : res.getRes_menu_list()) {
//	    		    getSession().save(menu);
//	    		}
//	    		getSession().saveOrUpdate(res);
//	    		commit();
	    			
//	    	        getSession().merge(res);
//	    	        getSession().evict(res);
	    	        
	    		
	    	} catch (Exception E) {
	    		E.printStackTrace();
	    		rollback();
	        }
	    }
	    
	    public List<Restaurant> searchRestaurantName(String res_name) {
	    	List<Restaurant> res_list = null;
	    	try {
	    		begin();
	    		Query q = getSession().createQuery("from Restaurant where res_name=:res_name");
	            q.setString("res_name", res_name);
	            res_list = q.list();
	            commit();
	            close();
	            
	         // Check if res_list is not empty before accessing its elements
	            if (!res_list.isEmpty()) {
	                System.out.println(res_list.get(0).getRes_name());
	            }
	            
	    	} catch (Exception e) {
	    		rollback();
	    		e.printStackTrace();
	    		
	    	}
	    	return res_list;
	    }
	    
//	    public List<Restaurant> searchRestaurantCity(String res_city) {
//	    	List<Restaurant> res_list = null;
//	    	List<Address> address = null;
//	    	AddressDAO addressDao = new AddressDAO();
//	    	try {
//	    		begin();
//	    		address = addressDao.searchAddresstCity(res_city);
//	    		for (int i = 0; i < address.size(); i++) {
//	    			int id = address.get(i).getAddrId();
//	    			Query q = getSession().createQuery("from Restaurant where res_add= :id");
//	    			q.setInteger("id", id);
//	    			res_list.add((Restaurant) q.uniqueResult());
//	    		}
//	    		
//	            
//	    	} catch (Exception e) {
//	    		rollback();
//	    	}
//	    	return res_list;
//	    }
//	    
//	    public List<Restaurant> searchRestaurantStreet(String res_street) {
//	    	List<Restaurant> res_list = null;
//	    	List<Address> address = null;
//	    	AddressDAO addressDao = new AddressDAO();
//	    	try {
//	    		begin();
//	    		address = addressDao.searchAddressStreet(res_street);
//	    		for (int i = 0; i < address.size(); i++) {
//	    			int id = address.get(i).getAddrId();
//	    			Query q = getSession().createQuery("from Restaurant where res_add= :id");
//	    			q.setInteger("id", id);
//	    			res_list.add((Restaurant) q.uniqueResult());
//	    		}
//	    		
//	            
//	    	} catch (Exception e) {
//	    		rollback();
//	    	}
//	    	return res_list;
//	    }
	    
	    public List<Menu> searchRestaurantMenu(int id) {
	    	List<Menu> menuList = null;
	    	Restaurant res = null;
	    	MenuDAO menuDao = new MenuDAO();
	    	try {
	    		begin();
	    		Query q = getSession().createQuery("from Restaurant_menutable where res_id=:res_id");
	    		q.setInteger("res_id", id);
	    		List<Integer> menuIds =  q.list();
	    		commit();
	    		for(int menu: menuIds) {
	    			Menu oneMenu = menuDao.getMenu(menu);
	    			menuList.add(oneMenu);
	    		}
	    		System.out.println(menuList.size() + " menu list size in DAO");
	    		close();
	    		
	    	} catch (Exception E) {
	    		rollback();
	    	}
	    	
	    	return menuList;
	    }
	    
	    public void addOrderToRestaurant(Orders order) {
	 	   
	    	try {
	    		
	    		begin();
	    		getSession().merge(order);
	    		commit();
//	    		getSession().evict(order);
	            close();
	    	} catch (Exception E) {
	    		rollback();
	            E.printStackTrace();
	        }
	    }
}
