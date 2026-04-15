package giuseppetavella.web_api_blogging.exceptions;

import giuseppetavella.web_api_blogging.payloads.ErrorsPayload;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFoundException(NotFoundException ex) {
        return new ErrorsPayload(ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleGenericException(Exception ex) {
        ex.printStackTrace();
        return new ErrorsPayload("C'è stato un error nei server. Stiamo risolvendo.");
    }
    
}
