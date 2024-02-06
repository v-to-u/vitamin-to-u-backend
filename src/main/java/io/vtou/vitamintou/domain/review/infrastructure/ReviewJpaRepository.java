package io.vtou.vitamintou.domain.review.infrastructure;

import io.vtou.vitamintou.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

}
