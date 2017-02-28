package com.davida.finalApp.validator;


import com.davida.finalApp.model.SignRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class SignRequestValidator implements Validator {

/*    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean supports(Class<?> paramClass) {
        return Email.class.equals(paramClass);
    }*/

    @Override
    public boolean supports(Class<?> paramClass) {
        return SignRequest.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deliverable", "valid.deliverable");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copy", "valid.copy");
    }
}