package org.yu.serve.auth.api;

/**
 * 封装API的错误码
 * Created by yu on 2019/4/19.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
