package com.dianping.data.warehouse.masterdata.core.utils;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

/**
 * Created by shanshan.jin on 14-3-5.
 */
public class ValidatorUtils {
    public static boolean validateModel(Object obj){
        StringBuffer buffer = new StringBuffer();
        javax.validation.Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();

        for(ConstraintViolation<Object> constraint : validator.validate(obj)){
            String message = constraint.getMessage();
            buffer.append(message);
        }
        if(StringUtils.isBlank(buffer.toString())){
            return true;
        }else{
            throw new javax.validation.ValidationException(buffer.toString());
        }


    }
    public static boolean validateProperty(Object obj, String... properties){
        StringBuffer buffer = new StringBuffer();
        javax.validation.Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();
        for(String property : properties ){
           for(ConstraintViolation<Object> constraint :validator.validateProperty(obj, property)){
               buffer.append(constraint.getMessage());
           }
        }
        if(StringUtils.isBlank(buffer.toString())){
            return true;
        }else{
            throw new javax.validation.ValidationException(buffer.toString());
        }
    }

}

