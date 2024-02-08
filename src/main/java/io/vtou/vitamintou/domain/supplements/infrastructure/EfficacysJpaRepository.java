package io.vtou.vitamintou.domain.supplements.infrastructure;

import io.vtou.vitamintou.domain.supplements.domain.Efficacys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EfficacysJpaRepository extends JpaRepository<Efficacys, String> {
}
