package io.vtou.vitamintou.domain.supplements.service;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsEfficiency;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsMaterial;
import io.vtou.vitamintou.domain.supplements.exception.SupplementsException;
import io.vtou.vitamintou.domain.supplements.infrastructure.*;
import io.vtou.vitamintou.domain.supplements.service.dto.req.*;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementsCreateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplementsApiService {

    private final EfficacysJpaRepository efficacysJpaRepository;
    private final SupplementsJpaRepository supplementsJpaRepository;
    private final EfficacyMappingJpaRepository efficacyMappingJpaRepository;
    private final RawMaterialsJpaRepository rawMaterialsJpaRepository;
    private final RawMaterialsMappingJpaRepository rawMaterialsMappingJpaRepository;

    public SupplementsCreateResponseDto save(SupplementsCreateRequestDto requestDto) {
        var result = supplementsJpaRepository.save(requestDto.toEntity());
        StringBuilder efficacys = new StringBuilder();
        StringBuilder rawMaterials = new StringBuilder();

        supplementsJpaRepository.findById(result.getId())
                .ifPresent(ignore -> {
                    throw new SupplementsException(ErrorCode.SUPPLEMENTS_EXISTS);
                });

        // 효능, 효능 매핑 추가
        for (SupplementsEfficiency supplementsEfficiency : SupplementsEfficiency.values()) {
            if (requestDto.getEfficacy().contains(supplementsEfficiency.getEfficiency())) {
                efficacys.append(supplementsEfficiency.getEfficiency()).append(",");
                EfficacysCreateRequestDto efficacysCreateRequestDto = EfficacysCreateRequestDto.builder()
                        .id(supplementsEfficiency.toString())
                        .name(supplementsEfficiency.getEfficiency())
                        .build();
                efficacysJpaRepository.findById(supplementsEfficiency.getEfficiency())
                        .ifPresentOrElse(ignore -> {
                            throw new SupplementsException(ErrorCode.EFFICACYS_EXISTS);
                        }, () -> efficacysJpaRepository.save(efficacysCreateRequestDto.toEntity()));
            }
        }
        EfficacysMappingCreateRequestDto efficacysMappingCreateRequestDto = EfficacysMappingCreateRequestDto.builder()
                .efficacysId(efficacys.toString())
                .supplementsId(result.getId())
                .build();
        efficacyMappingJpaRepository.save(efficacysMappingCreateRequestDto.toEntity());

        // 원재료, 원재료 매핑 추가
        for (SupplementsMaterial supplementsMaterial : SupplementsMaterial.values()) {
            if (requestDto.getRawMaterials().contains(supplementsMaterial.getMaterial())) {
                rawMaterials.append(supplementsMaterial.getMaterial()).append(",");
                RawMaterialsCreateRequestDto rawMaterialsCreateRequestDto = RawMaterialsCreateRequestDto.builder()
                        .id(supplementsMaterial.toString())
                        .name(supplementsMaterial.getMaterial())
                        .build();
                rawMaterialsJpaRepository.findById(supplementsMaterial.getMaterial())
                        .ifPresentOrElse(ignore -> {
                            throw new SupplementsException(ErrorCode.RAW_MATERIALS_EXISTS);
                        }, () -> rawMaterialsJpaRepository.save(rawMaterialsCreateRequestDto.toEntity()));
            }
        }
        RawMaterialsMappingCreateRequestDto rawMaterialsMappingCreateRequestDto = RawMaterialsMappingCreateRequestDto.builder()
                .rawMaterialsId(rawMaterials.toString())
                .supplementsId(result.getId())
                .build();
        rawMaterialsMappingJpaRepository.save(rawMaterialsMappingCreateRequestDto.toEntity());

        return SupplementsCreateResponseDto.from(result);
    }
}
