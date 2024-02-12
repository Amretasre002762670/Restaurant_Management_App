package com.webtools.ResManageApp.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.webtools.ResManageApp.pojo.Address;
import com.webtools.ResManageApp.pojo.Restaurant;

import org.springframework.validation.ValidationUtils;

@Component
public class RestaurantValidator implements Validator {
	public boolean supports(Class aClass)
    {
        return aClass.equals(Restaurant.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Restaurant newUser = (Restaurant) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "res_name", "error.invalid.restaurant", "Admin Name Required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "res_phoneNum", "error.invalid.restaurant", "Phone Number Required");
        
        Address address = newUser.getAddress();
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.streetName", "error.invalid.streetName", "Street Name is required");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.streetNum", "error.invalid.streetNum", "Street Number is required");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.city", "City is required");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.state", "State is required");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zipcode", "error.invalid.zipcode", "Zipcode is required");
	    
	    if (!Pattern.matches("^[a-zA-Z0-9]*$", newUser.getPassword())) {
	        errors.rejectValue("password", "error.invalid.password", "Password should contain only alphanumeric characters");
	    }
//	    if (!Pattern.matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", Long.toString(newUser.getRes_phoneNum()))) {
//	        errors.rejectValue("customer_phoneNum", "error.invalid.phoneNum", "Phone number should contain only numeric characters");
//	    }
	    if (!Pattern.matches("^[a-zA-Z]*$", address.getCity())) {
	        errors.rejectValue("address.city", "error.invalid.city", "City should contain only alphabets");
	    }
	    if (!Pattern.matches("^[a-zA-Z]*$", address.getState())) {
	        errors.rejectValue("address.state", "error.invalid.state", "State should contain only alphabets");
	    }
	    if (!Pattern.matches("^\\d{5}$", address.getZipcode())) {
	        errors.rejectValue("address.zipcode", "error.invalid.zipcode", "Zipcode should contain only numeric characters");
	    }
	    if (!Pattern.matches("^\\d{3}$", Integer.toString(address.getStreetNum()))) {
	        errors.rejectValue("address.streetNum", "error.invalid.streetNum", "Street Number should only be three digits");
	    }
        
	    if (!Pattern.matches("^-?[1-9]\\d*(\\.\\d+)?$", Long.toString(newUser.getRes_phoneNum()))) {
	        errors.rejectValue("res_phoneNum", "error.invalid.phoneNum", "Phone number is required");
	    }
    }
}
