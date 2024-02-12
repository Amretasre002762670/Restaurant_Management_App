package com.webtools.ResManageApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.webtools.ResManageApp.pojo.Address;

@Component
public class AddressValidator implements Validator {
	public boolean supports(Class aClass)
    {
        return aClass.equals(Address.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Address newUser = (Address) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetName", "error.invalid.address", "User Name Required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetNum", "error.invalid.address", "Password Required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.address", "City Required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.address", "State Required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipcode", "error.invalid.address", "zipcode Required");
        
        
    }
}
