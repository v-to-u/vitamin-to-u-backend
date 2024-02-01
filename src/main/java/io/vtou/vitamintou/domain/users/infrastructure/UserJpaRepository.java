package io.vtou.vitamintou.domain.users.infrastructure;

import io.vtou.vitamintou.domain.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

}
