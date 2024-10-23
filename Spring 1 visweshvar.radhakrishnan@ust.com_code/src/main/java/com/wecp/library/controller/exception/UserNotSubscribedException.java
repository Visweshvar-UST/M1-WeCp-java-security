package com.wecp.library.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserNotSubscribedException extends RuntimeException {
    public UserNotSubscribedException(String msg){
        super(msg);
    }
}