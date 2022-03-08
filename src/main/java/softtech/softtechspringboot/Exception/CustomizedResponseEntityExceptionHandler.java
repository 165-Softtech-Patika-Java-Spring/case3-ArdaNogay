package softtech.softtechspringboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import softtech.softtechspringboot.Exception.CommentException.NoProductCommentsFoundException;
import softtech.softtechspringboot.Exception.CommentException.NoUserCommentsFoundException;
import softtech.softtechspringboot.Exception.UserException.UserInformationMustBeUniqueException;
import softtech.softtechspringboot.Exception.UserException.UserInformationNotMatchedException;
import softtech.softtechspringboot.Exception.UserException.WrongUserInformationException;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest webRequest){

        Date errorDate = new Date();
        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllItemNotFoundException(ItemNotFoundException e, WebRequest webRequest){

        Date errorDate = new Date();
        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserInformationNotMatchedException(
            UserInformationNotMatchedException e, WebRequest webRequest){

        Date errorDate = new Date();
        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleWrongUserInformationException(
            WrongUserInformationException e, WebRequest webRequest){

        Date errorDate = new Date();
        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserInformationMustBeUniqueException(
            UserInformationMustBeUniqueException e, WebRequest webRequest){

        Date errorDate = new Date();
        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleNoProductCommentsFoundException(
            NoProductCommentsFoundException e, WebRequest webRequest){

        Date errorDate = new Date();
        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleNoUserCommentsFoundException(
            NoUserCommentsFoundException e, WebRequest webRequest){

        Date errorDate = new Date();
        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
