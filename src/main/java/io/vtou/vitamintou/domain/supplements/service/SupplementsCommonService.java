package io.vtou.vitamintou.domain.supplements.service;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.exception.SupplementsException;
import io.vtou.vitamintou.domain.supplements.infrastructure.SupplementsJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SupplementsCommonService {

    private final SupplementsJpaRepository supplementsRepository;

    @Transactional(readOnly = true)
    public void verifySupplementsId(Long supplementsId) {
        if (supplementsId == null || supplementsRepository.findById(supplementsId).isEmpty()) {
            throw new SupplementsException(ErrorCode.SUPPLEMENTS_NOT_FOUND);
        }
    }
}
