package fa.training.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity handleException(Exception ex, WebRequest request) throws Exception {
        ex.printStackTrace();

        throw ex;
    }
}
