package com.chao.demo.common.error;

import com.chao.demo.common.utils.DateTimeUtils;

/**
 * 统一异常类
 */
public class UniException extends Exception {

    private int code;

    private String message;

    private String devMessage;

    private String timestamp;

    public UniException(ErrorCode errorCode, Exception e) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.devMessage = e.getMessage();
        this.timestamp = DateTimeUtils.getNow();
    }

    public UniException(ErrorCode errorCode, Exception e, String message) {
        this.code = errorCode.getCode();
        this.message = message != null && "".equals(message) ? message : errorCode.getMessage();
        this.devMessage = e.getMessage();
        this.timestamp = DateTimeUtils.getNow();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
