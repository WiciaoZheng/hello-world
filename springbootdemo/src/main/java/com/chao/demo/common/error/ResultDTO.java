package com.chao.demo.common.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 前后端交互DTO
 */
@Data
@AllArgsConstructor
public class ResultDTO {

    private int code;

    private String message;

    private Object data;
}
