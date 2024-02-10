package io.vtou.vitamintou.domain.supplements.infrastructure;

import io.vtou.vitamintou.domain.supplements.domain.RawMaterials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawMaterialsJpaRepository extends JpaRepository<RawMaterials,String> {
}
