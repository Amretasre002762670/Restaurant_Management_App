package com.webtools.ResManageApp.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="addrId")
//    @GeneratedValue(generator = "sequence-generator")
//    @GenericGenerator(
//    	      name = "sequence-generator",
//    	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//    	      parameters = {
//    	        @Parameter(name = "sequence_name", value = "user_sequence"),
//    	        @Parameter(name = "initial_value", value = "1"),
//    	        @Parameter(name = "increment_size", value = "1")
//    	        }
//    	    )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int addrId = 0;
    
    @Column(name="streetName")
    private String streetName;
    
    @Column(name="streetNum")
    private int streetNum;
    
    @Column(name="city")
    private String city;
    
    @Column(name="state")
    private String state;
    
    @Column(name="zipcode")
    private String zipcode;
    
//    @OneToOne(mappedBy = "address")
//    Customer customer;
//    
//    @OneToOne(mappedBy="address")
//    Restaurant restaurant;
    
    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
}

