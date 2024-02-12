package com.webtools.ResManageApp.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.webtools.ResManageApp.pojo.Menu;

@Component
public class MenuValidator implements Validator {
	public boolean supports(Class aClass)
    {
        return aClass.equals(Menu.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Menu newMenu = (Menu) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menu_name", "error.invalid.menu", "Menu Name Required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menu_type", "error.invalid.menu", "Type of Menu Required");
        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menu_price", "error.invalid.menu", "Price Required");
        
        if (!Pattern.matches("^-?[1-9]\\d*(\\.\\d+)?$", Float.toString(newMenu.getMenu_price()))) {
	        errors.rejectValue("menu_price", "error.invalid.menu", "Price is required");
	    }
        
    }
}
