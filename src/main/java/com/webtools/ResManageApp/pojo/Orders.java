package com.webtools.ResManageApp.pojo;


import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

@Component
@Entity
//@Table(name="orderstable")
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId=6;
   
//	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
	
	@OneToMany(cascade = CascadeType.ALL)
	@ElementCollection
    @LazyCollection(LazyCollectionOption.EXTRA)
   private List<Menu> orderedMenu = new ArrayList<>();
   private String status;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "customer_id")
   private Customer customer;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "restaurant_id")
   private Restaurant restaurant;
   
// new UUID field
   @Column(name = "uuid", unique = true, nullable = false)
   private String uuid = UUID.randomUUID().toString();

   public long getOrderId() {
       return orderId;
   }

   public void setOrderId(long orderId) {
       this.orderId = orderId;
   }

   public List<Menu> getOrderedMenu() {
       return orderedMenu;
   }

   public void setOrderedMenu(List<Menu> orderedMenu) {
       this.orderedMenu = orderedMenu;
   }

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }
   
   public Customer getCustomer() {
       return customer;
   }

   public void setCustomer(Customer customer) {
       this.customer = customer;
   }

   public Restaurant getRestaurant() {
       return restaurant;
   }

   public void setRestaurant(Restaurant restaurant) {
       this.restaurant = restaurant;
   }
   
   public String getUuid() {
	    return uuid;
	}

	public void setUuid(String uuid) {
	    this.uuid = uuid;
	}
   
}

