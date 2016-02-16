package com.orange.client.exception;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
public class ClientException extends Exception {
    private ExceptionEntity exceptionEntity;

    public ExceptionEntity getExceptionEntity() {
        return exceptionEntity;
    }

    public void setExceptionEntity(ExceptionEntity exceptionEntity) {
        this.exceptionEntity = exceptionEntity;
    }

    public ClientException(ExceptionEntity exceptionEntity){
        this.exceptionEntity=exceptionEntity;
    }
}
