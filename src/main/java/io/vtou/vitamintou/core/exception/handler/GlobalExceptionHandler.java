package io.vtou.vitamintou.core.exception.handler;

import io.vtou.vitamintou.core.exception.dto.ExceptionResponse;
import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ExceptionResponse> handleException(Exception e, HttpServletRequest request) {
        return ExceptionResponse.toResponseEntity(ErrorCode.SERVER_ERROR, e.getMessage());
    }
}
