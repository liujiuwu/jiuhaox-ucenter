package com.jiuhaox.ucenter.adapter.inbound.config;

import com.jiuhaox.foundation.consts.CommonConst;
import com.jiuhaox.foundation.model.resp.Resp;
import io.micrometer.core.instrument.util.StringUtils;
import jakarta.annotation.PostConstruct;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Rest接口全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @PostConstruct
    public void init() {
        log.info("Rest接口全局异常处理初始化");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Resp handleError(MissingServletRequestParameterException e) {
        log.warn("缺少请求参数", e.getMessage());
        return Resp.fail(String.format("缺少必要的请求参数: %s", e.getParameterName()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Resp handleError(MethodArgumentTypeMismatchException e) {
        log.warn("请求参数格式错误", e.getMessage());
        return Resp.fail(String.format("请求参数格式错误: %s", e.getName()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Resp handleError(BindException e) {
        log.warn("参数验证失败:{}", e.getMessage());
        return Resp.fail(errorMsgs(e.getBindingResult()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Resp handleError(ConstraintViolationException e) {
        log.warn("参数验证失败:", e.getMessage());
        final Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation violation = violations.iterator().next();
        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
        return Resp.fail(String.format("%s:%s", path, violation.getMessage()));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Resp handleError(NoHandlerFoundException e) {
        log.error("404没找到请求:{}", e.getMessage());
        return Resp.fail(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Resp handleError(HttpMessageNotReadableException e) {
        log.error("消息不能读取:{}", e.getMessage());
        return Resp.fail(e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Resp handleError(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法:{}", e.getMessage());
        return Resp.fail(e.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Resp handleError(HttpMediaTypeNotSupportedException e) {
        log.error("不支持当前媒体类型:{}", e.getMessage());
        return Resp.fail(e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public Resp handleError(Throwable e) {
        log.error("全局异常", e);
        return Resp.fail(e.getMessage());
    }

    private String errorMsgs(BindingResult bindingResult) {
        List<FieldError> fes = bindingResult.getFieldErrors();
        for (final FieldError fe : fes) {

            System.out.println(fe.getField()+":"+fe.getDefaultMessage());
        }
        String errors = fes.stream().filter(v -> StringUtils.isNotBlank(v.getDefaultMessage())).map(FieldError::getDefaultMessage).sorted(Comparator.comparing(v -> v)).collect(Collectors.joining(CommonConst.SEMICOLON));
        log.debug("参数校验异常|{}", errors);
        return errors;
    }
}
