package com.webtools.ResManageApp.utils;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;


import com.webtools.ResManageApp.pojo.User;
import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Address;
import com.webtools.ResManageApp.pojo.Menu;
import com.webtools.ResManageApp.pojo.Orders;
import com.webtools.ResManageApp.pojo.Restaurant;

@Component
public class HibernateUtil {
	
	  private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();

	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ordersManageDB?createDatabaseIfNotExist=true");
	                settings.put(Environment.USER, "root");
	                settings.put(Environment.PASS, "amre1999");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

	                settings.put(Environment.SHOW_SQL, "true");

	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	                settings.put(Environment.HBM2DDL_AUTO, "update");

	                configuration.setProperties(settings);

	                //Add annotated Pojo's here
	                
//	                configuration.addAnnotatedClass(User.class);
	                configuration.addAnnotatedClass(Customer.class);
	                configuration.addAnnotatedClass(Restaurant.class);
	                configuration.addAnnotatedClass(Menu.class);
	                configuration.addAnnotatedClass(Orders.class);
	                configuration.addAnnotatedClass(Address.class);

	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
}
