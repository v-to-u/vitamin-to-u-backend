package io.vtou.vitamintou.DTO;

import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsShape;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplementsDto {
    private Long id;
    private String name;
    private String companyName;
    private String expiryMonth;
    private String storageMethods;
    private String caveats;
    private String appearance;
    private String referenceStandard;
    private String efficacy;
    private String supplementsShape;
    private String rawMaterials;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
