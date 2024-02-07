package io.vtou.vitamintou.domain.supplements.service.dto.req;

import io.vtou.vitamintou.domain.supplements.domain.Supplements;

import java.time.LocalDate;

import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsShape;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SupplementsCreateRequestDto {

    private final Long id;
    private final String name;
    private final String companyName;
    private final String expiryMonth;
    private final String storageMethods;
    private final String caveats;
    private final String appearance;
    private final String referenceStandard;
    private final String supplementsShape;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;

    @Builder
    private SupplementsCreateRequestDto(Long id, String name, String companyName, String expiryMonth,
                                        String storageMethods, String caveats, String appearance, String referenceStandard, String supplementsShape, LocalDate createdAt,
                                        LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.expiryMonth = expiryMonth;
        this.storageMethods = storageMethods;
        this.caveats = caveats;
        this.appearance = appearance;
        this.referenceStandard = referenceStandard;
        this.supplementsShape = supplementsShape;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Supplements toEntity() {
        return Supplements.builder()
                .id(id)
                .name(name)
                .companyName(companyName)
                .expiryMonth(expiryMonth)
                .storageMethods(storageMethods)
                .caveats(caveats)
                .appearance(appearance)
                .referenceStandard(referenceStandard)
                .supplementsShape(supplementsShape)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
