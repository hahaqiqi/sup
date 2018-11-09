package com.haha.user.emums;

public enum  ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "登录成功"),
    USER_INEXISTENCE(100, "用户不存在"),
    USER_ERROR(101, "用户名或密码错误"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
