package io.vtou.vitamintou.domain.review.domain.exception;

import io.vtou.vitamintou.core.exception.CustomException;
import io.vtou.vitamintou.core.exception.enums.ErrorCode;


public class ReviewException extends CustomException {

    public ReviewException(ErrorCode errorCode,
        String exceptionValue) {
        super(errorCode, exceptionValue);
    }

    public ReviewException(ErrorCode errorCode) {
        super(errorCode);
    }
}
