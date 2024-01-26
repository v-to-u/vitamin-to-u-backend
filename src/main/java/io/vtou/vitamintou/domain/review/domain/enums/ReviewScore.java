package io.vtou.vitamintou.domain.review.domain.enums;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.review.domain.exception.ReviewException;
import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ReviewScore {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    private final int value;

    public static ReviewScore findByValue(int value) {
        return Arrays.stream(ReviewScore.values()).filter(score -> score.value == value).findAny()
            .orElseThrow(() -> new ReviewException(ErrorCode.REVIEW_SCORE_NOT_FOUND));
    }
}
