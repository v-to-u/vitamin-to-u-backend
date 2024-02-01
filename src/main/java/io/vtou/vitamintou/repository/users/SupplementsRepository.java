package io.vtou.vitamintou.repository.users;

import io.vtou.vitamintou.domain.supplements.domain.Supplements;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface SupplementsRepository extends JpaRepository<Supplements,Long> {
}
