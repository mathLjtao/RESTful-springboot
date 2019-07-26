package com.ljtao.RESTfulspringboot.exception;

public class BussinesException extends RuntimeException{
    private String code;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    BussinesException(){}
    public BussinesException(String code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
