package com.webtools.ResManageApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Address;

@Component
public class CustomerLoginValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Customer.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	
    	    Customer customer = (Customer) obj;
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer_name", "error.invalid.customer", "Customer Name is required");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password is required");
    	   
    	    
    	    
    
    }
}
