package com.store.online.Exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.store.online.Controller.CartController;
import com.store.online.Controller.ProductController;

/**
 * @author Harikrishnan
 *
 */
@ControllerAdvice(basePackageClasses= {CartController.class, ProductController.class})
public class GeneralExceptionHandler {
	Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

	@ExceptionHandler(ServletRequestBindingException.class)
    public final ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request) 
    {
		logger.debug("handleHeaderException");
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Bad Request", details);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
     
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) 
    {
    	logger.debug("handleAllExceptions");
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        logger.debug("Exception : "+ ex.getMessage());
        ErrorResponse error = new ErrorResponse("Server Error", details);
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
