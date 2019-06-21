package com.lf.ssm.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationUtil {
    public static void assertValidation(BindingResult errors){
        if(errors.hasErrors()){
            /* 变量所有的异常信息 */
            List<ObjectError> errorList = errors.getAllErrors();
            for (ObjectError error : errorList) {
                FieldError fieldError = (FieldError) error;
                throw new RuntimeException(fieldError.getDefaultMessage());
            }
        }
    }
}
