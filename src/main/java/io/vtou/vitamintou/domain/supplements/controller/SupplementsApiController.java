package io.vtou.vitamintou.domain.supplements.controller;

import io.vtou.vitamintou.domain.supplements.infrastructure.provider.SupplementsOpenApiProvider;
import io.vtou.vitamintou.domain.supplements.service.SupplementsApiService;
import io.vtou.vitamintou.domain.supplements.service.dto.req.SupplementsCreateRequestDto;
import io.vtou.vitamintou.domain.supplements.service.dto.res.SupplementsCreateResponseDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SupplementsApiController {

    private final SupplementsOpenApiProvider openApiProvider;
    private final SupplementsApiService supplementsService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @GetMapping("/api/load")
    public List<SupplementsCreateResponseDto> addDataFromOpenApi() {
        List<SupplementsCreateResponseDto> response = new java.util.ArrayList<>(List.of());
        var openApiResponse = openApiProvider.requestAllSupplementsDataApi();
        openApiResponse.getJSONObject("C003").getJSONArray("row").forEach(o -> {
            var temp = (JSONObject) o;
            Long supId = Long.parseLong((String) temp.get("PRDLST_REPORT_NO"));
            log.info(temp.get("PRIMARY_FNCLTY").toString());
            SupplementsCreateRequestDto requestDto = SupplementsCreateRequestDto.builder()
                .id(supId)
                .name(temp.getString("PRDLST_NM"))
                .companyName(temp.getString("BSSH_NM"))
                .expiryMonth(temp.getString("POG_DAYCNT"))
                .storageMethods(temp.getString("CSTDY_MTHD"))
                .caveats(temp.getString("IFTKN_ATNT_MATR_CN"))
                .appearance(temp.getString("DISPOS"))
                .referenceStandard(temp.getString("STDR_STND"))
                .efficacy(temp.getString("PRIMARY_FNCLTY"))
                .supplementsShape(temp.getString("SHAP"))
                .rawMaterials(temp.getString("RAWMTRL_NM"))
                .createdAt(LocalDate.parse(temp.getString("PRMS_DT"), formatter))
                .updatedAt(LocalDate.parse(temp.getString("LAST_UPDT_DTM"), formatter))
                .build();


            response.add(supplementsService.save(requestDto));
        });
        return response;
    }

}
