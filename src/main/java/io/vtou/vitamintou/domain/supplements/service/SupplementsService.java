package io.vtou.vitamintou.domain.supplements.service;

import io.vtou.vitamintou.domain.supplements.infrastructure.SupplementsJpaRepository;
import io.vtou.vitamintou.domain.supplements.service.dto.req.SupplementsCreateRequestDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementsCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplementsService {

    private final SupplementsJpaRepository supplementsRepository;

    public SupplementsCreateResponseDto save(SupplementsCreateRequestDto requestDto) {
        var result = supplementsRepository.save(requestDto.toEntity());
        return SupplementsCreateResponseDto.from(result);
    }
}
