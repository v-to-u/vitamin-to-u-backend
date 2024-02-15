package io.vtou.vitamintou.domain.supplements.infrastructure;

import io.vtou.vitamintou.domain.supplements.domain.EfficacyMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfficacyMappingJpaRepository extends JpaRepository<EfficacyMapping,Long> {
}
