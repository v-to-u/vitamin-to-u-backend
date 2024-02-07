package io.vtou.vitamintou.domain.users.service;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.users.exception.UserException;
import io.vtou.vitamintou.domain.users.infrastructure.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCommonService {

    private final UserJpaRepository userRepository;

    @Transactional(readOnly = true)
    public void verifyUserId(Long userId) {
        if (userId == null || userRepository.findById(userId).isEmpty()) {
            throw new UserException(ErrorCode.USER_NOT_FOUND);
        }
    }
}
