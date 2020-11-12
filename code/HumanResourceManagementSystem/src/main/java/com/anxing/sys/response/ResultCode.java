package com.anxing.sys.response;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(2000, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

	
	VERIFY_SESSION_ERROR(1003,"验证码错误"),
	NONEXIT(1004,"用户不存在"),
	PWD_ERROR(1005,"密码错误"),
	
	NONUSER(1006,"当前没有已登录的用户"),
	
    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}