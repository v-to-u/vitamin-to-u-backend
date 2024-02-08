package io.vtou.vitamintou.domain.supplements.service.dto.req;

import io.vtou.vitamintou.domain.supplements.domain.RawMaterials;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RawMaterialsCreateRequestDto {
    private final String id;
    private final String name;

    @Builder
    private RawMaterialsCreateRequestDto(String id,String name){
        this.id=id;
        this.name=name;
    }

    public RawMaterials toEntoty(){
        return RawMaterials.builder().id(id).name(name).build();
    }

}
