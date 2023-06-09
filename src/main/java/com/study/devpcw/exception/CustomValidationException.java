package com.study.devpcw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class CustomValidationException  extends RuntimeException{

    private Map<String, String> errorMap;
}
