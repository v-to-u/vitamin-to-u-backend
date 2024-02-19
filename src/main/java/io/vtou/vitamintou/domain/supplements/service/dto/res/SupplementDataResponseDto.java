package io.vtou.vitamintou.domain.supplements.service.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SupplementDataResponseDto {
    private SupplementResponseDto supplementResponseDto;
    private String price;
}
