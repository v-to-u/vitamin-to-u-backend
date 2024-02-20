package io.vtou.vitamintou.domain.supplements.service;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsEfficiency;
import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsMaterial;
import io.vtou.vitamintou.domain.supplements.exception.SupplementsException;
import io.vtou.vitamintou.domain.supplements.infrastructure.SupplementsJpaRepository;
import io.vtou.vitamintou.domain.supplements.service.dto.res.NaverApiResponseDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementDataResponseDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import static io.vtou.vitamintou.domain.supplements.domain.QSupplements.supplements;
import static io.vtou.vitamintou.domain.supplements.domain.QEfficacyMapping.efficacyMapping;
import static io.vtou.vitamintou.domain.supplements.domain.QRawMaterialsMapping.rawMaterialsMapping;

@Slf4j
@Service
@RequiredArgsConstructor
public class SupplementsCommonService {

    private final SupplementsJpaRepository supplementsRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final ShoppingService shoppingService;

    @Transactional(readOnly = true)
    public void verifySupplementsId(Long supplementsId) {
        if (supplementsId == null || supplementsRepository.findById(supplementsId).isEmpty()) {
            throw new SupplementsException(ErrorCode.SUPPLEMENTS_NOT_FOUND);
        }
    }

    @Transactional
    public String[] makeEfficacysList(){
        String[] efficacys=new String[SupplementsEfficiency.values().length];
        int count=0;
        for(SupplementsEfficiency supplementsEfficiency : SupplementsEfficiency.values()){
            efficacys[count]=supplementsEfficiency.getEfficiency();
            count++;
        }
        return efficacys;
    }

    @Transactional
    public String[] makeRawMaterialsList(){
        String[] rawMaterials=new String[SupplementsMaterial.values().length];
        int count=0;
        for(SupplementsMaterial supplementsMaterial : SupplementsMaterial.values()){
            rawMaterials[count]= supplementsMaterial.getMaterial();
            count++;
        }
        return rawMaterials;
    }

    @Transactional
    public SupplementDataResponseDto makeSupplement(Long id){
        SupplementResponseDto result=null;
        result = jpaQueryFactory
                .select(Projections.constructor(SupplementResponseDto.class,supplements.name
                        ,efficacyMapping.efficacysId.as("efficacys"),rawMaterialsMapping.rawMaterialsId.as("rawMaterials")
                        ,supplements.createdAt.as("makeDate"),supplements.companyName,supplements.efficacy.as("description")))
                .from(supplements,efficacyMapping,rawMaterialsMapping)
                .where(supplements.id.eq(id),efficacyMapping.supplementsId.eq(id),rawMaterialsMapping.supplementsId.eq(id))
                .fetchOne();

        if(result==null) {
            throw new SupplementsException(ErrorCode.SUPPLEMENTS_NOT_FOUND);
        } else{
            String[] efficacysList = new String[0];
            String[] rawMaterialsList= new String[0];
            if(!result.getEfficacys().isEmpty()){
                efficacysList = result.getEfficacys().split(",");
            }
            if(!result.getRawMaterials().isEmpty()){
                rawMaterialsList = result.getRawMaterials().split(",");
            }
            NaverApiResponseDto naverApiResponseDto=shoppingService.search(result.getName());
            if(naverApiResponseDto==null){
                return new SupplementDataResponseDto(
                        result.getName(),result.getMakeDate(),result.getCompanyName()
                        ,result.getDescription(),efficacysList,rawMaterialsList,""
                );
            }
            else{
                return new SupplementDataResponseDto(
                        result.getName(),result.getMakeDate(),result.getCompanyName()
                        ,result.getDescription(),efficacysList,rawMaterialsList,naverApiResponseDto.getLprice()
                );
            }
        }
    }

    @Transactional
    public BufferedImage getImage(String name){
        String link=shoppingService.search(name).getImage();
        log.info(link);
        try{
            URL url=new URL(link);

            return ImageIO.read(url);
        }
        catch (IOException e){
            return null;
        }
    }
}
