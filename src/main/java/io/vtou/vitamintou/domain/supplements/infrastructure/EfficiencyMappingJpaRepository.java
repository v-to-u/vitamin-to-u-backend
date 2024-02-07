package io.vtou.vitamintou.domain.supplements.infrastructure;

import io.vtou.vitamintou.domain.supplements.domain.EfficiencyMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EfficiencyMappingJpaRepository extends JpaRepository<EfficiencyMapping,Long> {
}
