package io.vtou.vitamintou.domain.review.service.dto.req;

import io.vtou.vitamintou.domain.review.domain.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateReviewRequest {

    private final Long userId;
    private final Long supplementsId;
    private final String content;
    private final int reviewScore;

    @Builder
    private CreateReviewRequest(long userId, long supplementsId, String content, int reviewScore) {
        this.userId = userId;
        this.supplementsId = supplementsId;
        this.content = content;
        this.reviewScore = reviewScore;
    }

    public Review toEntity() {
        return Review.builder()
            .userId(userId)
            .supplementsId(supplementsId)
            .content(content)
            .reviewScore(reviewScore)
            .build();
    }
}
