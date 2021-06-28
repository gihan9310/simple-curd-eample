package com.gihanz.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Slf4j
public class StudentException extends RuntimeException{

    public StudentException(String message) {
        super(message);
        log.info(message);
    }
}
