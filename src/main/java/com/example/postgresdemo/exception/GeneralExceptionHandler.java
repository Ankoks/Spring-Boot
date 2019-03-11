package com.example.postgresdemo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;


/**
 * User: ankoks
 * Date: 11/03/2019
 */
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionFrontEnd> handleAll(Exception ex, NativeWebRequest request) {
        ExceptionFrontEnd exceptionFrontEnd = new ExceptionFrontEnd(ex.getMessage(), "Очень плохая ошибка на бэке");

        return ResponseEntity.ok(exceptionFrontEnd);
    }
}
