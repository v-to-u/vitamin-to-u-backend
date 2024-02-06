package io.vtou.vitamintou.domain.review.infrastructure;

import io.vtou.vitamintou.domain.review.domain.Review;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUserIdAndSupplementsId(Long userId, Long supplementsId);

    Optional<Review> findByIdAndUserId(Long id, Long userId);
}
