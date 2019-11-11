package SpringBoot.RestAPI.messenger.Exception.handler;

import SpringBoot.RestAPI.messenger.Exception.DataNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DataNotFoundException.class)
    protected ResponseEntity<Object> dataNotFound(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "data not found exception";

        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(bodyOfResponse);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "handleAllExceptions";

        ex.printStackTrace();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(bodyOfResponse);
    }
}
