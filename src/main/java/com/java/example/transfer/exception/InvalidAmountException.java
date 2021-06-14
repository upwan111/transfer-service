package com.java.example.transfer.exception;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String msg, Throwable e) {
        super(msg,e);
    }
    public InvalidAmountException(String msg) {
        super(msg);
    }
}
