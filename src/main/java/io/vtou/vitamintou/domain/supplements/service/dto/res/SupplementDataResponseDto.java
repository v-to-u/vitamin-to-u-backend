package io.vtou.vitamintou.domain.supplements.service.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class SupplementDataResponseDto {
    private String name;
    private LocalDate makeDate;
    private String companyName;
    private String description;
    private String[] efficacys;
    private String[] rawMaterials;
    private String price;
}
