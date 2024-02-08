package io.vtou.vitamintou.domain.supplements.service;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.exception.SupplementsException;
import io.vtou.vitamintou.domain.supplements.infrastructure.EfficacysJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EfficiacysCommonService {

    private final EfficacysJpaRepository efficacysJpaRepository;

    @Transactional(readOnly = true)
    public void existEfficacysId(String efficiacysId){
        if(efficacysJpaRepository.existsById(efficiacysId)){
            throw new SupplementsException(ErrorCode.EFFICACYS_EXISTED);
        }
    }
}
