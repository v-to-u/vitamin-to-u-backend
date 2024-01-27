package io.vtou.vitamintou.domain.review.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.vtou.vitamintou.domain.review.exception.ReviewException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ReviewScore Enum Test")
class ReviewScoreTest {

    @DisplayName("test find ReviewScore by value Success")
    @Test
    void testFindByValueSuccess() {
        // Arrange
        int expectedValue = 3;
        // Act
        ReviewScore actualResult = ReviewScore.findByValue(expectedValue);
        // Assert
        assertThat(actualResult).hasFieldOrPropertyWithValue("value", expectedValue)
            .isEqualTo(ReviewScore.THREE);
    }

    @DisplayName("test find ReviewScore by value Fail")
    @Test
    void testFindByValueFail() {
        // Arrange
        int expectedValue = 0;
        // Act & Assert
        assertThrows(ReviewException.class, () -> ReviewScore.findByValue(expectedValue));
    }
}