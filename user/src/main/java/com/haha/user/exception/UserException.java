package com.haha.user.exception;

import com.haha.user.emums.ResultEnum;
import org.apache.shiro.authc.AuthenticationException;

public class UserException  extends AuthenticationException {
    private Integer code;

    public UserException(ResultEnum userenum){
        super(userenum.getMsg());
        this.code=userenum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
