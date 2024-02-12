package com.webtools.ResManageApp.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.webtools.ResManageApp.pojo.Customer;
import com.webtools.ResManageApp.pojo.Address;

@Component
public class CustomerValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Customer.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	
    	    Customer customer = (Customer) obj;
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer_name", "error.invalid.customer", "Customer Name is required");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password is required");
//    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer_phoneNum", "error.invalid.phoneNum", "Phone number is required");
    	    
    	    Address address = customer.getAddress();
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.streetName", "error.invalid.streetName", "Street Name is required");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.streetNum", "error.invalid.streetNum", "Street Number is required");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.city", "City is required");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.state", "State is required");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zipcode", "error.invalid.zipcode", "Zipcode is required");
    	    
    	    if (!Pattern.matches("^[a-zA-Z0-9]*$", customer.getPassword())) {
    	        errors.rejectValue("password", "error.invalid.password", "Password should contain only alphanumeric characters");
    	    }
//    	    if (!Pattern.matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", Long.toString(customer.getCustomer_phoneNum()))) {
//    	        errors.rejectValue("customer_phoneNum", "error.invalid.phoneNum", "Phone number should contain only numeric characters");
//    	    }
    	    if (!Pattern.matches("^[a-zA-Z]*$", address.getCity())) {
    	        errors.rejectValue("address.city", "error.invalid.city", "City should contain only alphabets");
    	    }
    	    if (!Pattern.matches("^\\d{3}$", Integer.toString(address.getStreetNum()))) {
    	        errors.rejectValue("address.city", "error.invalid.city", "City should contain only alphabets");
    	    }
    	    if (!Pattern.matches("^[a-zA-Z]*$", address.getState())) {
    	        errors.rejectValue("address.state", "error.invalid.state", "State should contain only alphabets");
    	    }
    	    if (!Pattern.matches("^\\d{5}$", address.getZipcode())) {
    	        errors.rejectValue("address.zipcode", "error.invalid.zipcode", "Zipcode should contain only numeric characters");
    	    }
    	    if (!Pattern.matches("^-?[1-9]\\d*(\\.\\d+)?$", Long.toString(customer.getCustomer_phoneNum()))) {
    	        errors.rejectValue("customer_phoneNum", "error.invalid.phoneNum", "Phone number is required");
    	    }
    
    }
}
