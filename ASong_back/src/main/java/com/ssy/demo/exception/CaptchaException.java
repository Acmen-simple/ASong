package com.ssy.demo.exception;

import javax.security.sasl.AuthenticationException;

public class CaptchaException extends AuthenticationException {
    public CaptchaException(String msg){
        super(msg);
    }
}
