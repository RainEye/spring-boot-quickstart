package com.tapwater.archetypes.springbootquickstart.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private static final Integer DEFAULT_FAIL_CODE = -1;

    private Integer code;

    private String message;

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message) {
        this.code = DEFAULT_FAIL_CODE;
        this.message = message;
    }
}
