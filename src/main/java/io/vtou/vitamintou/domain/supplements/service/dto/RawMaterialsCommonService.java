package io.vtou.vitamintou.domain.supplements.service.dto;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.exception.SupplementsException;
import io.vtou.vitamintou.domain.supplements.infrastructure.RawMaterialsJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RawMaterialsCommonService {

    private final RawMaterialsJpaRepository rawMaterialsJpaRepository;

    @Transactional(readOnly = true)
    public void existRawMaterialsId(String RawMaterialsId){
        if(rawMaterialsJpaRepository.existsById(RawMaterialsId)){
            throw new SupplementsException(ErrorCode.RAW_MATERIALS_EXISTED);
        }
    }
}
