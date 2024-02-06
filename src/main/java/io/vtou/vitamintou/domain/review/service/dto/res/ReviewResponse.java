package io.vtou.vitamintou.domain.review.service.dto.res;

import io.vtou.vitamintou.domain.review.domain.Review;
import io.vtou.vitamintou.domain.review.domain.enums.ReviewScore;
import lombok.Getter;

@Getter
public class ReviewResponse {

    private final Long id;
    private final Long userId;
    private final Long supplementsId;
    private final String content;
    private final ReviewScore reviewScore;

    private ReviewResponse(Long id, Long userId, Long supplementsId, String content,
        ReviewScore reviewScore) {
        this.id = id;
        this.userId = userId;
        this.supplementsId = supplementsId;
        this.content = content;
        this.reviewScore = reviewScore;
    }

    public static ReviewResponse from(Review review) {
        return new ReviewResponse(
            review.getId(),
            review.getUserId(),
            review.getSupplementsId(),
            review.getContent(),
            review.getReviewScore()
        );
    }
}
