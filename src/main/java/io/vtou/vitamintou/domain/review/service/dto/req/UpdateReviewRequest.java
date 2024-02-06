package io.vtou.vitamintou.domain.review.service.dto.req;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.users.exception.UserException;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateReviewRequest {

    private final long userId;
    private final String content;
    private final int reviewScore;

    @Builder
    private UpdateReviewRequest(Long userId, String content, int reviewScore) {
        if(userId == null){
            throw new UserException(ErrorCode.REVIEW_USER_ID_NOT_BLANK);
        }
        this.userId = userId;
        this.content = content;
        this.reviewScore = reviewScore;
    }
}
