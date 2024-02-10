package io.vtou.vitamintou.domain.supplements.service.dto.req;

import io.vtou.vitamintou.domain.supplements.domain.EfficacyMapping;
import io.vtou.vitamintou.domain.supplements.domain.RawMaterials;
import io.vtou.vitamintou.domain.supplements.domain.RawMaterialsMapping;
import lombok.Builder;
import lombok.Getter;

@Getter
public class EfficacysMappingCreateRequestDto {
    private final Long id;
    private final String efficacysId;
    private final Long supplementsId;

    @Builder
    private EfficacysMappingCreateRequestDto(Long id, String efficacysId, Long supplementsId){
        this.id=id;
        this.efficacysId=efficacysId;
        this.supplementsId=supplementsId;
    }

    public EfficacyMapping toEntity(){
        return EfficacyMapping.builder().id(id).efficacysId(efficacysId).supplementsId(supplementsId).build();
    }

}
