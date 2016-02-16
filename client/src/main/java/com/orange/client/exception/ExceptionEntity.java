package com.orange.client.exception;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
public class ExceptionEntity {
    private int errCode;

    private String errMsg;

    public ExceptionEntity(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ExceptionEntity() {
        errCode = 0;
        errMsg = "";
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ExceptionEntity{" +
                "错误代码=" + errCode +
                ", 错误信息='" + errMsg + '\'' +
                '}';
    }
}
