package com.webtools.ResManageApp.pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.ArrayList;
import  org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;
import  org.hibernate.annotations.GenericGenerator;

@Component
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int customer_id=0;
    
    private String customer_name;
    
    @OneToOne
    @JoinColumn(name = "addr_id", referencedColumnName = "addrId")
    private Address address;
    
    private long customer_phoneNum;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    @Column(name="orders")
////    @JoinColumn(name="orderId", referencedColumnName="orderId")
//    private List<Orders> ordersList = new ArrayList<>(); //mappedBy property is what we use to tell Hibernate which variable we are using to represent the parent class in our child class.
    
//    @OneToOne(mappedBy="customer")
//    private User userCredentials;
    
    @Column(name="Password")
    private String password;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getCustomer_phoneNum() {
        return customer_phoneNum;
    }

    public void setCustomer_phoneNum(long customer_phoneNum) {
        this.customer_phoneNum = customer_phoneNum;
    }

//    public List<Orders> getOrdersList() {
//        return ordersList;
//    }
//
//    public void setOrdersList(List<Orders> ordersList) {
//        this.ordersList = ordersList;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

