package com.stackroute.customerservice.authenticationservice;

<<<<<<< HEAD:authentication-service/src/main/java/com/stackroute/customerservice/authenticationservice/CentralizedExceptionHandler.java
import com.stackroute.customerservice.authenticationservice.exception.InvalidCredentialsException;
=======
import com.stackroute.authenticationservice.exception.UserAlredyExistException;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:authentication-service/src/main/java/com/stackroute/authenticationservice/CentralizedExceptionHandler.java
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public String handleNotFound(Exception e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            UserAlredyExistException.class
    })
    public String handleUserAlreadyExists(Exception e) {
        return "Already Exists";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
    })
    public String handleInvalidArgument(Exception e) {
        return "Invalid arguments";
    }

}
