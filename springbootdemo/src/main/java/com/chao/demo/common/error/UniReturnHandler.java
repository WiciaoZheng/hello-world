package com.chao.demo.common.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 返回处理类，返回给上层/前端等
 */
public class UniReturnHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniReturnHandler.class);

    /**
     * 请求成功时返回给前端的数据
     * @param data 返回给前端的数据
     * @return ResultDTO
     */
    public static ResultDTO successResult(Object data) {
        return new ResultDTO(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 请求失败时返回给前端的数据
     * @param data 返回给前端的数据
     * @return ResultDTO
     */
    public static ResultDTO failResult(Object data) {
        return new ResultDTO(ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getMessage(), data);
    }

    /**
     * 异常捕获时返回给前端的数据
     * @param e 异常
     * @return ResultDTO
     */
    public static ResultDTO exceptionResult(Exception e) {
        UniException exp = null;
        if (e instanceof UniException) {
            exp = (UniException) e;
        } else {
            exp = new UniException(ErrorCode.UNCATEGORIZED, e);
        }
        return new ResultDTO(exp.getCode(), exp.getMessage(), null);
    }
}
