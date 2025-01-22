package com.alura.forohuboracle.infra.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity errorHandlerValidationException(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
