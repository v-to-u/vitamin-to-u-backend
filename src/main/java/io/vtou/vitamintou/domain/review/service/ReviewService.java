package io.vtou.vitamintou.domain.review.service;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.review.domain.Review;
import io.vtou.vitamintou.domain.review.exception.ReviewException;
import io.vtou.vitamintou.domain.review.infrastructure.ReviewJpaRepository;
import io.vtou.vitamintou.domain.review.service.dto.req.CreateReviewRequest;
import io.vtou.vitamintou.domain.review.service.dto.req.UpdateReviewRequest;
import io.vtou.vitamintou.domain.review.service.dto.res.ReviewResponse;
import io.vtou.vitamintou.domain.supplements.service.SupplementsCommonService;
import io.vtou.vitamintou.domain.users.service.UserCommonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewJpaRepository reviewRepository;
    private final UserCommonService userCommonService;
    private final SupplementsCommonService supplementsCommonService;

    public ReviewResponse createReview(CreateReviewRequest request) {
        userCommonService.verifyUserId(request.getUserId());
        supplementsCommonService.verifySupplementsId(request.getSupplementsId());
        Review review = request.toEntity();
        reviewRepository.findByUserIdAndSupplementsId(request.getUserId(),
            request.getSupplementsId()).ifPresentOrElse(ignore -> {
            throw new ReviewException(ErrorCode.REVIEW_ALREADY_EXISTS);
        }, () -> reviewRepository.save(review));
        return ReviewResponse.from(review);
    }

    public Long deleteReview(Long reviewId, Long userId) {
        Review review = reviewRepository.findByIdAndUserId(reviewId, userId)
            .orElseThrow(() -> new ReviewException(ErrorCode.REVIEW_NOT_FOUND));
        reviewRepository.delete(review);
        return reviewId;
    }

    public ReviewResponse updateReview(long reviewId, UpdateReviewRequest request) {
        Review review = reviewRepository.findByIdAndUserId(reviewId, request.getUserId())
            .orElseThrow(() -> new ReviewException(ErrorCode.REVIEW_NOT_FOUND));
        review.updateReviewValues(request.getContent(), request.getReviewScore());
        return ReviewResponse.from(review);
    }

    @Transactional(readOnly = true)
    public List<ReviewResponse> getReviewsBySupplementsId(Long supplementsId) {
        supplementsCommonService.verifySupplementsId(supplementsId);
        return reviewRepository.findBySupplementsId(supplementsId).stream()
            .map(ReviewResponse::from)
            .toList();
    }


}
