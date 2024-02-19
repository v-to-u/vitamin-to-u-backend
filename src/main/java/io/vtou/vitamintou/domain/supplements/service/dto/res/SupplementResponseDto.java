package io.vtou.vitamintou.domain.supplements.service.dto.res;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplementResponseDto {
    private String name;
    private String efficacys;
    private String rawMaterials;
    private LocalDate makeDate;
    private String companyName;
    private String description;
}
