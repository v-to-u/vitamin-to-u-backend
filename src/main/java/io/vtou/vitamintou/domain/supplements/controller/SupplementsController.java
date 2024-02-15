package io.vtou.vitamintou.domain.supplements.controller;

import io.vtou.vitamintou.domain.supplements.service.SupplementsCommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String[] returnRawMaterials(){
        return supplementsCommonService.makeRawMaterialsList();
    }
}
