package com.tapwater.archetypes.springbootquickstart.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResponse<T> {

    private static final Integer DEFAULT_OK_CODE = 0;

    private static final String DEFAULT_OK_MSG = "成功";

    private static final Integer DEFAULT_FAIL_CODE = -1;

    private static final String DEFAULT_FAIL_MSG = "失败";

    private Integer code;

    private String message;

    private T data;

    public static RestResponse<Object> ok() {
        return new RestResponse<>(DEFAULT_OK_CODE, DEFAULT_OK_MSG, null);
    }

    public static <T> RestResponse<T> ok(T data) {
        return new RestResponse<>(DEFAULT_OK_CODE, DEFAULT_OK_MSG, data);
    }

    public static RestResponse<Object> fail() {
        return new RestResponse<>(DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG, null);
    }

    public static <T> RestResponse<T> fail(T data) {
        return new RestResponse<>(DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG, data);
    }

    public static RestResponse<Object> fail(Integer code, String message) {
        return new RestResponse<>(code, message, null);
    }

    public static <T> RestResponse<T> fail(Integer code, String message, T data) {
        return new RestResponse<>(code, message, data);
    }
}
