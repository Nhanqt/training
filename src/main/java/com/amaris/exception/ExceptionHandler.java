package com.amaris.exception;

import com.amaris.exception.exceptions.NotAllowException;
import com.amaris.exception.responseMessage.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotAllowException.class)
//    public ResponseEntity<Object> exception(NotAllowException exception) {
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                }
        );
        ErrorResponse errorResponse = new ErrorResponse(400,"Validation Error", errors);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotAllowException.class)
//    protected ResponseEntity<Object> handlesNotFoundException(NotFoundException ex){
//        int statusCode = HttpStatus.NOT_FOUND.value();
//        String message = ex.getMessage();
//        ErrorResponse errorResponse = new ErrorResponse(statusCode,message);
//        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotAllowException.class)
    protected ResponseEntity<Object> handlesNotAllowException(NotAllowException ex){
        int statusCode = HttpStatus.BAD_REQUEST.value();
        String message = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(statusCode,message);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
