package io.vtou.vitamintou.domain.supplements.service.dto.res;

import io.vtou.vitamintou.domain.supplements.domain.Supplements;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsShape;

import java.time.LocalDate;

public class SupplementsCreateResponseDto {

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

    private SupplementsCreateResponseDto(Long id, String name, String companyName,
                                         String expiryMonth,
                                         String storageMethods, String caveats, String appearance, String referenceStandard,
                                         String supplementsShape, LocalDate createdAt,
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

    public static SupplementsCreateResponseDto from(Supplements supplements) {
        return new SupplementsCreateResponseDto(
                supplements.getId(),
                supplements.getName(),
                supplements.getCompanyName(),
                supplements.getExpiryMonth(),
                supplements.getStorageMethods(),
                supplements.getCaveats(),
                supplements.getAppearance(),
                supplements.getReferenceStandard(),
                supplements.getSupplementsShape(),
                supplements.getCreatedAt(),
                supplements.getUpdatedAt()
        );
    }
}
