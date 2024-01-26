package io.vtou.vitamintou.core.exception.enums;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 500
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버에 문제가 발생하였습니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
