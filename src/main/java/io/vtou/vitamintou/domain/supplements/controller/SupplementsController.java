package io.vtou.vitamintou.domain.supplements.controller;

import io.vtou.vitamintou.domain.supplements.service.SupplementsCommonService;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementDataResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


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
