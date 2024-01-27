package io.vtou.vitamintou.domain.users.exception;

import io.vtou.vitamintou.core.exception.CustomException;
import io.vtou.vitamintou.core.exception.enums.ErrorCode;

public class UserException extends CustomException {

    public UserException(ErrorCode errorCode,
        String exceptionValue) {
        super(errorCode, exceptionValue);
    }

    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
