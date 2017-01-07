package com.java2.web.control;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
public class BusinessExceptionHandler extends AbstractExceptionHandler {

//	 @ExceptionHandler(NullPointerException.class)
//	    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	    @ResponseBody DefaultErrorMessage handleNullPointerException() {
//
//	        String error = getResourceBundle().getMessage("exception.npe", null, Locale.getDefault());
//
//	        return new DefaultErrorMessage("RS00230", "SYSTEM_ERROR", error);
//
//	    }
}
