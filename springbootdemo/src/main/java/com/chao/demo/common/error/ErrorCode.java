package com.chao.demo.common.error;

/**
 * ErrorCode
 */
public enum ErrorCode {

    SUCCESS(0, "操作成功"),

    FAILURE(-1, "操作失败"),

    UNCATEGORIZED(999, "未归类的错误"),

    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已过期"),
    FORBIDDEN(403, "无使用/操作权限"),
    NOT_FOUND(404, "资源不存在"),

    SERVICE_DENIED(500, "服务拒绝"),
    PARAM_TYPE_ERROR(511, "参数类型错误"),
    PARAM_NUMBER_ERROR(512, "参数个数错误"),
    PARAM_FORMAT_ERROR(513, "参数格式错误"),
    PARAM_LENGTH_ERROR(514, "参数长度错误"),

    DB_INSERT_ERROR(601, "数据库插入错误"),
    DB_UPDATE_ERROR(602, "数据库更新错误"),
    DB_DELETE_ERROR(603, "数据库删除错误"),
    DB_SELECT_ERROR(604, "数据库查询错误"),
    DB_SELECT_EMPTY(604, "数据库查询结果为空"),
    DB_SELECT_MANY(604, "数据库查询结果多于一个");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" + "code=" + code + ", message='" + message + '}';
    }
}
