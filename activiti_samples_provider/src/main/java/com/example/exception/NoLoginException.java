package com.example.exception;

/**
 * @author yanzt
 * @date 2018/12/11 15:34
 * @describe 未登录异常
 */
public class NoLoginException extends RuntimeException {

    public NoLoginException() {
        super();
    }

    public NoLoginException(String message) {
        super(message);
    }
}
