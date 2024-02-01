package io.vtou.vitamintou.core.exception.dto;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@RequiredArgsConstructor
public class ExceptionResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int statusCode;
    private final String statusCodeName;
    private final String code;
    private final String message;
    private final String runtimeValue;

    public static ResponseEntity<ExceptionResponse> toResponseEntity(ErrorCode errorCode,
        String runtimeValue) {
        return ResponseEntity
            .status(errorCode.getHttpStatus())
            .body(new ExceptionResponse(
                errorCode.getHttpStatus().value(),
                errorCode.getHttpStatus().name(),
                errorCode.name(),
                errorCode.getMessage(),
                runtimeValue
            ));
    }
}
