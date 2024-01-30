package io.vtou.vitamintou.domain.review.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.vtou.vitamintou.domain.review.exception.ReviewException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ReviewLike Entity Test")
class ReviewLikeTest {

    @Test
    void testCreateReviewLikeSuccess() {
        // Arrange
        Long expectedUserId = 1L;
        Long expectedReviewId = 1L;
        // Act
        var actualResult = ReviewLike.builder()
            .userId(expectedUserId)
            .reviewId(expectedReviewId)
            .build();
        // Assert
        assertThat(actualResult).hasFieldOrPropertyWithValue("userId", expectedUserId)
            .hasFieldOrPropertyWithValue("reviewId", expectedReviewId);
    }

    @Test
    void testCreateReviewLikeFailWhenUserIdIsNull() {
        // Arrange
        Long expectedReviewId = 1L;
        // Act & Assert
        assertThrows(ReviewException.class, ReviewLike.builder()
            .userId(null)
            .reviewId(expectedReviewId)::build);
    }

    @Test
    void testCreateReviewLikeFailWhenReviewIdIsNull() {
        // Arrange
        Long expectedUserId = 1L;
        // Act & Assert
        assertThrows(ReviewException.class, ReviewLike.builder()
            .userId(expectedUserId)
            .reviewId(null)::build);
    }
}