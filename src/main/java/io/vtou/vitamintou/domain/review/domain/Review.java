package io.vtou.vitamintou.domain.review.domain;

import io.vtou.vitamintou.domain.review.domain.enums.ReviewScore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Entity
@Table(name = "review_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "supplements_id", nullable = false)
    private Long supplementsId;

    @Lob
    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_score", nullable = false)
    private ReviewScore reviewScore;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    private Review(Long userId, Long supplementsId, String content, int reviewScore) {
        this.userId = userId;
        this.supplementsId = supplementsId;
        this.content = content;
        this.reviewScore = ReviewScore.findByValue(reviewScore);
    }

    public void updateReviewValues(String content, int reviewScore) {
        this.content = content;
        this.reviewScore = ReviewScore.findByValue(reviewScore);
    }
}
