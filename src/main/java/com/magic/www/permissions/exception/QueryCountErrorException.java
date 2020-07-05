package com.magic.www.permissions.exception;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/17
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 *
 * 查询数量异常，本应该查询出点掉结果但实际查询出多条结果
 */

public class QueryCountErrorException extends RuntimeException {
    public QueryCountErrorException() {
    }

    public QueryCountErrorException(String message) {
        super(message);
    }

    public QueryCountErrorException(Throwable cause) {
        super(cause);
    }

    public QueryCountErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
