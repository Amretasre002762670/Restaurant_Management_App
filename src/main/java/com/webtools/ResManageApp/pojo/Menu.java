package com.webtools.ResManageApp.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="menutable")
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name="menuId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int menu_id = 0;
    
    public String menu_name;
    
    public String menu_type;
    
    public float menu_price;
    
//    @ManyToOne
//    @JoinColumn(name="fkrestaurantmenu", nullable=false, referencedColumnName = "res_id")
//    Restaurant restaurant;
    
//    private Customer customer;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public float getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(float menu_price) {
        this.menu_price = menu_price;
    }
    
    
}