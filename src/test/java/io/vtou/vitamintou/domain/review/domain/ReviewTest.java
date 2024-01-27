package io.vtou.vitamintou.domain.review.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.vtou.vitamintou.domain.review.domain.enums.ReviewScore;
import io.vtou.vitamintou.domain.review.exception.ReviewException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("test Review Entity")
class ReviewTest {

    @Test
    void testCreateReviewSuccess() {
        // Arrange
        String expectedUserId = "testId";
        long expectedSupplementsId = 1L;
        String expectedContent = "테스트";
        int expectedReviewScoreInt = 5;
        // Act
        var actualResult = Review.builder()
            .userId(expectedUserId)
            .supplementsId(expectedSupplementsId)
            .content(expectedContent)
            .reviewScore(expectedReviewScoreInt)
            .build();
        // Assert
        assertThat(actualResult)
            .hasFieldOrPropertyWithValue("userId", expectedUserId)
            .hasFieldOrPropertyWithValue("supplementsId", expectedSupplementsId)
            .hasFieldOrPropertyWithValue("content", expectedContent)
            .hasFieldOrPropertyWithValue("reviewScore",
                ReviewScore.findByValue(expectedReviewScoreInt));
    }

    @Test
    void testCreateReviewFail() {
        // Arrange
        String expectedUserId = "testId";
        long expectedSupplementsId = 1L;
        String expectedContent = "테스트";
        int expectedReviewScoreInt = 6;
        // Act & Assert
        assertThrows(ReviewException.class, Review.builder()
            .userId(expectedUserId)
            .supplementsId(expectedSupplementsId)
            .content(expectedContent)
            .reviewScore(expectedReviewScoreInt)::build);
    }

    @Test
    void testUpdateReviewValuesSuccess() {
        // Arrange
        String expectedUserId = "testId";
        long expectedSupplementsId = 1L;
        String expectedContent = "테스트";
        int expectedReviewScoreInt = 5;
        var expectedReview = Review.builder()
            .userId(expectedUserId)
            .supplementsId(expectedSupplementsId)
            .content(expectedContent)
            .reviewScore(expectedReviewScoreInt)
            .build();
        expectedContent = "변환된 테스트";
        expectedReviewScoreInt = 3;
        // Act
        expectedReview.updateReviewValues(expectedContent, expectedReviewScoreInt);
        // Assert
        assertThat(expectedReview)
            .hasFieldOrPropertyWithValue("userId", expectedUserId)
            .hasFieldOrPropertyWithValue("supplementsId", expectedSupplementsId)
            .hasFieldOrPropertyWithValue("content", expectedContent)
            .hasFieldOrPropertyWithValue("reviewScore",
                ReviewScore.findByValue(expectedReviewScoreInt));
    }

    @Test
    void testUpdateReviewValuesFail() {
        // Arrange
        String expectedUserId = "testId";
        long expectedSupplementsId = 1L;
        String expectedContent = "테스트";
        int expectedReviewScoreInt = 5;
        var expectedReview = Review.builder()
            .userId(expectedUserId)
            .supplementsId(expectedSupplementsId)
            .content(expectedContent)
            .reviewScore(expectedReviewScoreInt)
            .build();
        int expectWrongReviewScore = 9;
        // Act & Assert
        assertThrows(ReviewException.class,
            () -> expectedReview.updateReviewValues(expectedContent, expectWrongReviewScore));
    }
}