package com.tapsCabs.exceptionHandler;


import com.tapsCabs.DTO.ErrorResponse;
import com.tapsCabs.exceptions.CabNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote all exception handler class
 */
@ControllerAdvice
public class TapsCabsExceptionsHandler {

   private ErrorResponse exceptionResponse(Exception e, String logRef) {
       ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setLogRef(logRef);
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTypeOfException(e.getClass().getSimpleName());
        //errorResponse.setRequestedResource(r.uri().toString());
    return errorResponse;
    }

    @ExceptionHandler(CabNotFoundException.class)
    ResponseEntity<ErrorResponse> cabNotFoundExceptionHandler(CabNotFoundException e){

       return new ResponseEntity<ErrorResponse>(exceptionResponse(e,e.getLogRef()), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<ErrorResponse> otherExceptionHandler(UsernameNotFoundException e){

        return new ResponseEntity<ErrorResponse>(exceptionResponse(e," "), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponse> otherExceptionHandler(Exception e){

        return new ResponseEntity<ErrorResponse>(exceptionResponse(e," "),HttpStatus.INTERNAL_SERVER_ERROR);

    }






}
