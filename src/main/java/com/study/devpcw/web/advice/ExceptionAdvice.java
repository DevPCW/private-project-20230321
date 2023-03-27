package com.study.devpcw.web.advice;

import com.study.devpcw.exception.CustomValidationException;
import com.study.devpcw.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationError(CustomValidationException e) {
        return ResponseEntity
                .badRequest()
                .body(new CMRespDto<>(HttpStatus
                        .BAD_REQUEST.value(),
                        "Validation Error",
                        e.getErrorMap()));
    }
}
