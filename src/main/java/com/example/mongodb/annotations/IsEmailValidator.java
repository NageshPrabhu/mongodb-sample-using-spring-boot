package com.example.mongodb.annotations;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IsEmailValidator implements ConstraintValidator<IsEmail, String> {

    private String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(StringUtils.isBlank(email))
            return false;
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email.trim()).matches();
    }
}
