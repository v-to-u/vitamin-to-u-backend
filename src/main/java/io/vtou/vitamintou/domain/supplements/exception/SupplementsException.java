package io.vtou.vitamintou.domain.supplements.exception;

import io.vtou.vitamintou.core.exception.CustomException;
import io.vtou.vitamintou.core.exception.enums.ErrorCode;

public class SupplementsException extends CustomException {

    public SupplementsException(ErrorCode errorCode,
        String exceptionValue) {
        super(errorCode, exceptionValue);
    }

    public SupplementsException(ErrorCode errorCode) {
        super(errorCode);
    }
}
