package com.exercise.store.exception;

import javax.servlet.http.HttpServletRequest;

import com.exercise.store.bean.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Response<String> handleServiceException(HttpServletRequest req, Exception ex) {

        Response<String> response = new Response<>();

        response.setStatusCode("01");
        response.setStatusDescription("Invalid Service");
        response.setResponse(ex.getMessage());

        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Response<String> handleProductNotFoundException(HttpServletRequest req, Exception ex) {

        Response<String> response = new Response<>();

        response.setStatusCode("02");
        response.setStatusDescription("Invalid Service");
        response.setResponse(ex.getMessage());

        return response;
    }
}
