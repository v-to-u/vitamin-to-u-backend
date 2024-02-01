package io.vtou.vitamintou.service.supplements;

import io.vtou.vitamintou.DTO.SupplementsDto;
import io.vtou.vitamintou.domain.supplements.domain.Supplements;
import io.vtou.vitamintou.repository.users.SupplementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SupplementsService {
    @Autowired
    private final SupplementsRepository supplementsRespository;

    public void save(SupplementsDto supplementsDto){
        Supplements supplements=Supplements.builder()
                .id(supplementsDto.getId())
                .name(supplementsDto.getName())
                .appearance(supplementsDto.getAppearance())
                .caveats(supplementsDto.getCaveats())
                .companyName(supplementsDto.getCompanyName())
                .expiryMonth(supplementsDto.getExpiryMonth())
                .efficacy(supplementsDto.getEfficacy())
                .rawMaterials(supplementsDto.getRawMaterials())
                .referenceStandard(supplementsDto.getReferenceStandard())
                .storageMethods(supplementsDto.getStorageMethods())
                .supplementsShape(supplementsDto.getSupplementsShape())
                .createdAt(LocalDate.now())
                .build();
        supplementsRespository.save(supplements);
    }
}
