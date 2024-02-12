package com.webtools.ResManageApp.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.webtools.ResManageApp.pojo.Address;
import com.webtools.ResManageApp.pojo.Restaurant;

import org.springframework.validation.ValidationUtils;

@Component
public class RestaurantLoginValidator implements Validator {
	public boolean supports(Class aClass)
    {
        return aClass.equals(Restaurant.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Restaurant newUser = (Restaurant) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "res_name", "error.invalid.restaurantlogin", "Admin Name Required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");

        
    }
}
