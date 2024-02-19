package io.vtou.vitamintou.domain.supplements.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.domain.Supplements;
import io.vtou.vitamintou.domain.supplements.exception.SupplementsException;
import io.vtou.vitamintou.domain.supplements.service.SupplementsApiService;
import io.vtou.vitamintou.domain.supplements.service.SupplementsCommonService;
import io.vtou.vitamintou.domain.supplements.service.dto.req.SupplementsCreateRequestDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.NaverApiResponseDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementDataResponseDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementResponseDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/supplements")
public class SupplementsController {

    private final SupplementsCommonService supplementsCommonService;

    // 효능 리스트 반환
    @GetMapping("/efficacys")
    public String[] returnEfficacys() {
        return supplementsCommonService.makeEfficacysList();
    }

    // 원재료 리스트 반환
    @GetMapping("/rawMaterials")
    public String[] returnRawMaterials() {
        return supplementsCommonService.makeRawMaterialsList();
    }

    @GetMapping("/supplement")
    public SupplementDataResponseDto returnSupplement(@RequestParam Long supplementId) {
        return supplementsCommonService.makeSupplement(supplementId);
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getSupplementImage(String name) throws IOException {
        BufferedImage bufferedImage = supplementsCommonService.getImage(name);

        ByteArrayOutputStream bArr = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", bArr);

        return bArr.toByteArray();
    }
}
