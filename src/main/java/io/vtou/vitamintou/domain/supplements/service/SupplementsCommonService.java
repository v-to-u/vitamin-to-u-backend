package io.vtou.vitamintou.domain.supplements.service;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsEfficiency;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsMaterial;
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

    @Transactional
    public String[] makeEfficacysList(){
        String[] efficacys=new String[SupplementsEfficiency.values().length];
        int count=0;
        for(SupplementsEfficiency supplementsEfficiency : SupplementsEfficiency.values()){
            efficacys[count]=supplementsEfficiency.getEfficiency();
            count++;
        }
        return efficacys;
    }

    @Transactional
    public String[] makeRawMaterialsList(){
        String[] rawMaterials=new String[SupplementsMaterial.values().length];
        int count=0;
        for(SupplementsMaterial supplementsMaterial : SupplementsMaterial.values()){
            rawMaterials[count]= supplementsMaterial.getMaterial();
            count++;
        }
        return rawMaterials;
    }
}
