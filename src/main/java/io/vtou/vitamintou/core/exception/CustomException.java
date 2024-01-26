package io.vtou.vitamintou.core.exception;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String exceptionValue;

    public CustomException(ErrorCode errorCode, String exceptionValue) {
        this.errorCode = errorCode;
        this.exceptionValue = exceptionValue;
    }

    public CustomException(ErrorCode errorCode) {
        this(errorCode, "exceptionValue does not exist.");
    }
}
