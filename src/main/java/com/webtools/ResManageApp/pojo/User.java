package com.webtools.ResManageApp.pojo;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GeneratorType;

@Entity
@Table
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="UserName")
    private String name;
    @Column(name="Password")
    private String password;
    @Column(name="Type")
    private String type;
    
//    @OneToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
//    private Customer customer;
//    
//    @OneToOne
//    @JoinColumn(name = "res_id", referencedColumnName = "res_id")
//    private Restaurant restaurant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
