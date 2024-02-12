package com.webtools.ResManageApp.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Fetch;


@Entity
//@Table(name="restauranttable")
public class Restaurant implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int res_id=0;
    
    private String res_name;
    
//    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
//    private List<Menu> res_menu_list = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Menu> res_menu_list = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="res_add", referencedColumnName="addrId")
    private Address address;
    
    private long res_phoneNum;
    
    @Column(name="Password")
    private String password;
    

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public long getRes_phoneNum() {
        return res_phoneNum;
    }

    public void setRes_phoneNum(long res_phoneNum) {
        this.res_phoneNum = res_phoneNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Menu> getRes_menu_list() {
        return res_menu_list;
    }

    public void setRes_menu_list(List<Menu> res_menu_list) {
        this.res_menu_list = res_menu_list;
    }
    
    public void addMenu(Menu menu) {
    	res_menu_list.add(menu);
    }
    

//    public User getUserCredentials() {
//        return userCredentials;
//    }
//
//    public void setUserCredentials(User userCredentials) {
//        this.userCredentials = userCredentials;
//    }

//    public Set<Menu> getRes_menu_list() {
//        return res_menu_list;
//    }
//
//    public void setRes_menu_list(Set<Menu> res_menu_list) {
//        this.res_menu_list = res_menu_list;
//    }

//    public Set<Orders> getOrders() {
//        return ordersList;
//    }
//
//    public void setOrders(Set<Orders> orders) {
//        this.ordersList = orders;
//    }
    
}