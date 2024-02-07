package io.vtou.vitamintou.domain.supplements.service;

import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsEfficiency;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsMaterial;
import io.vtou.vitamintou.domain.supplements.infrastructure.SupplementsJpaRepository;
import io.vtou.vitamintou.domain.supplements.service.dto.req.SupplementsCreateRequestDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementsCreateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SupplementsService {

    private final SupplementsJpaRepository supplementsRepository;

    public SupplementsCreateResponseDto save(SupplementsCreateRequestDto requestDto) {
        var result = supplementsRepository.save(requestDto.toEntity());

        for(SupplementsEfficiency supplementsEfficiency : SupplementsEfficiency.values()){
            if(requestDto.getEfficacy().contains(supplementsEfficiency.getEfficiency())){

            }
        }

        return SupplementsCreateResponseDto.from(result);
    }
}
