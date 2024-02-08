package io.vtou.vitamintou.domain.supplements.service.dto.req;

import io.vtou.vitamintou.domain.supplements.domain.Efficacys;
import lombok.Builder;
import lombok.Getter;

@Getter
public class EfficacysCreateRequestDto {
    private final String id;
    private final String name;

    @Builder
    private EfficacysCreateRequestDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Efficacys toEntity() {
        return Efficacys.builder().id(id).name(name).build();
    }
}
