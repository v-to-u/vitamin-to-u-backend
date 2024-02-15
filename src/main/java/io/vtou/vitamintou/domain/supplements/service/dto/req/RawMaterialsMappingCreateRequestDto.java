package io.vtou.vitamintou.domain.supplements.service.dto.req;

import io.vtou.vitamintou.domain.supplements.domain.EfficacyMapping;
import io.vtou.vitamintou.domain.supplements.domain.RawMaterialsMapping;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RawMaterialsMappingCreateRequestDto {
    private final Long id;
    private final String rawMaterialsId;
    private final Long supplementsId;

    @Builder
    private RawMaterialsMappingCreateRequestDto(Long id, String rawMaterialsId, Long supplementsId){
        this.id=id;
        this.rawMaterialsId=rawMaterialsId;
        this.supplementsId=supplementsId;
    }

    public RawMaterialsMapping toEntity(){
        return RawMaterialsMapping.builder().id(id).rawMaterialsId(rawMaterialsId).supplementsId(supplementsId).build();
    }
}
