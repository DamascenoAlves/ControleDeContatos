package br.com.mda.ControleDecontatos.resource.handlers;


import br.com.mda.ControleDecontatos.dto.CustomError;
import br.com.mda.ControleDecontatos.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionsHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(),httpStatus.value() ,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(err);
    }
    
}
