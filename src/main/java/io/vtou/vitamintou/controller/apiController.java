package io.vtou.vitamintou.controller;

import io.vtou.vitamintou.DTO.SupplementsDto;
import io.vtou.vitamintou.domain.supplements.domain.Supplements;
import io.vtou.vitamintou.repository.users.SupplementsRepository;
import io.vtou.vitamintou.service.supplements.SupplementsService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class apiController {

    @Autowired
    private SupplementsRepository supplementsRepository;
    @Autowired
    private SupplementsService supplementsService;

    @GetMapping("/api/load")
    public void Apiload(){
        String result="";
        try{
            URL url=new URL("http://openapi.foodsafetykorea.go.kr/api/c4942a942d494115af3c/C003/json/1/2/");

            BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            result=br.readLine();

            JSONParser jsonParser=new JSONParser();
            JSONObject jsonObject=(JSONObject) jsonParser.parse(result);
            JSONObject C003=(JSONObject)jsonObject.get("C003");
            JSONArray Arr=(JSONArray) C003.get("row");

            for(int i=0;i<Arr.size();i++){
                JSONObject tmp=(JSONObject)Arr.get(i);
                Long sup_id=Long.parseLong((String)tmp.get("PRDLST_REPORT_NO"));
                System.out.println(((String)tmp.get("PRIMARY_FNCLTY")).length());
                SupplementsDto infoObj=SupplementsDto.builder()
                        .id(sup_id)
                        .name((String)tmp.get("PRDLST_NM"))
                        .companyName((String)tmp.get("BSSH_NM"))
                        .expiryMonth((String)tmp.get("POG_DAYCNT"))
                        .storageMethods((String)tmp.get("CSTDY_MTHD"))
                        .caveats((String)tmp.get("IFTKN_ATNT_MATR_CN"))
                        .appearance((String)tmp.get("DISPOS"))
                        .referenceStandard((String)tmp.get("STDR_STND"))
                        .efficacy((String)tmp.get("PRIMARY_FNCLTY"))
                        .supplementsShape((String)tmp.get("SHAP"))
                        .rawMaterials((String)tmp.get("RAWMTRL_NM"))
                        .build();

                supplementsService.save(infoObj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
