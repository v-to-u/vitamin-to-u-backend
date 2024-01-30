package io.vtou.vitamintou.domain.review.domain;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.review.exception.ReviewException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review_like_tb")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "review_id", nullable = false, updatable = false)
    private Long reviewId;

    @Builder
    private ReviewLike(Long userId, Long reviewId) {
        verifyUserId(userId);
        verifyReviewId(reviewId);
        this.userId = userId;
        this.reviewId = reviewId;
    }

    private static void verifyUserId(Long userId) {
        if (userId == null) {
            throw new ReviewException(ErrorCode.REVIEW_LIKE_USER_ID_NOT_BLANK);
        }
    }

    private static void verifyReviewId(Long reviewId) {
        if (reviewId == null) {
            throw new ReviewException(ErrorCode.REVIEW_LIKE_REVIEW_ID_NOT_BLANK);
        }
    }
}
