package io.vtou.vitamintou.domain.supplements.infrastructure;

import io.vtou.vitamintou.domain.supplements.domain.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementsJpaRepository extends JpaRepository<Supplements, Long> {
}
