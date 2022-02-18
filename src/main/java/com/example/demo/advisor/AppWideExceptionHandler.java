package com.example.demo.advisor;

import com.example.demo.exeption.EntryDuplicateException;
import com.example.demo.exeption.EntryNotFoundException;
import com.example.demo.util.StandardLogger;
import com.example.demo.util.StandardResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler({EntryDuplicateException.class})
    public ResponseEntity duplicateExceptionHandler(EntryDuplicateException e){
        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
        return new ResponseEntity(
                new StandardResponse(404, "Entries Duplicate Exception",
                        e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntryNotFoundException.class})
    public ResponseEntity notFoundExceptionHandler(EntryNotFoundException e){
        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
        return new ResponseEntity(
                new StandardResponse(404, "Entries Not Found Exception", e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    protected ResponseEntity apiValidationHandler(ConstraintViolationException e){
        LoggerHandler.handleLogger(new StandardLogger("erro",e.getMessage()));
        return new ResponseEntity(
                new StandardResponse(400, "Validation Exception", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) ->{
            errors.put(
                    ((FieldError) error).getField(),
                    error.getDefaultMessage()
            );
        });
        return new ResponseEntity(
                new StandardResponse(400, "Validation Exception", errors),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity globalExceptionHandler(Throwable e){
        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
        return new ResponseEntity(
                new StandardResponse(500, "Server Error", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler({UsernameNotFoundException.class})
//    protected ResponseEntity usernameNotFoundExceptionHandler(UsernameNotFoundException e){
//        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
//        return new ResponseEntity(
//                new StandardResponse(404, "Username Not Found", e.getMessage()),
//                HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler({SecurityException.class})
    public ResponseEntity servletException(SecurityException e){
        LoggerHandler.handleLogger(new StandardLogger("error",e.getMessage()));
        return new ResponseEntity(
                new StandardResponse(401, "Authorization not valid", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }



}
