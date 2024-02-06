package io.vtou.vitamintou.core.exception.enums;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 500
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버에 문제가 발생하였습니다."),
    // 400
    REVIEW_SCORE_NOT_FOUND(BAD_REQUEST, "정의되지 않은 리뷰 점수입니다."),
    USER_UUID_NOT_BLANK(BAD_REQUEST, "유저 UUID는 공백이 될 수 없습니다."),
    USER_NICKNAME_NOT_BLANK(BAD_REQUEST, "유저 닉네임은 공백이 될 수 없습니다."),
    REVIEW_LIKE_USER_ID_NOT_BLANK(BAD_REQUEST, "유저 ID는 공백이 될 수 없습니다."),
    REVIEW_LIKE_REVIEW_ID_NOT_BLANK(BAD_REQUEST, "리뷰 ID는 공백이 될 수 없습니다."),
    REVIEW_ALREADY_EXISTS(BAD_REQUEST, "이미 리뷰가 존재합니다."),
    // 404
    SUPPLEMENTS_NOT_FOUND(NOT_FOUND, "해당 영양제를 찾을 수 없습니다."),
    USER_NOT_FOUND(NOT_FOUND, "해당 유저를 찾을 수 없습니다."),
    REVIEW_NOT_FOUND(NOT_FOUND, "해당 리뷰를 찾을 수 없습니다.");
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
