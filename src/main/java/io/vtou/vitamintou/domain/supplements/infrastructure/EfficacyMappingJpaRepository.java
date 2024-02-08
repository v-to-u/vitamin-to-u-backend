package io.vtou.vitamintou.domain.supplements.infrastructure;

import io.vtou.vitamintou.domain.supplements.domain.EfficacyMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EfficacyMappingJpaRepository extends JpaRepository<EfficacyMapping,Long> {
}
