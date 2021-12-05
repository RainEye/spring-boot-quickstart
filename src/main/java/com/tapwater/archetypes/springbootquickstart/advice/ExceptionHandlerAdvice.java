package com.tapwater.archetypes.springbootquickstart.advice;

import com.tapwater.archetypes.springbootquickstart.exception.BusinessException;
import com.tapwater.archetypes.springbootquickstart.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 处理业务异常
     * @param exception 异常对象
     * @return 包装返回值
     */
    @ExceptionHandler(BusinessException.class)
    public RestResponse<Object> businessExceptionHandler(BusinessException exception){
        return RestResponse.fail(exception.getCode(), exception.getMessage());
    }

    /**
     * 处理运行时异常
     * @param exception 异常对象
     * @return 包装返回值
     */
    @ExceptionHandler(RuntimeException.class)
    public RestResponse<Object> runtimeExceptionHandler(RuntimeException exception){
        log.error(exception.getMessage() , exception);
        return RestResponse.fail(exception.getMessage());
    }

    /**
     * 处理参数校验异常
     * @param exception 异常对象
     * @return 包装返回值
     */
    @ExceptionHandler(BindException.class)
    public RestResponse<Object> bindExceptionHandler(BindException exception) {
        List<FieldError> fieldErrors = exception.getFieldErrors();
        return RestResponse.fail(fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(";")));
    }

    /**
     * 处理参数校验异常
     * @param exception 异常对象
     * @return 包装返回值
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResponse<Object> bindExceptionHandler(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        if(fieldError != null) {
            return RestResponse.fail(fieldError.getDefaultMessage());
        } else {
            return RestResponse.fail(exception.getMessage());
        }
    }

    /**
     * 处理所有未捕获的异常
     * @param exception 异常对象
     * @return 包装返回值
     */
    @ExceptionHandler(Exception.class)
    public RestResponse<Object> exceptionHandler(Exception exception){
        log.error(exception.getMessage() , exception);
        return RestResponse.fail(exception.getMessage());
    }
}
