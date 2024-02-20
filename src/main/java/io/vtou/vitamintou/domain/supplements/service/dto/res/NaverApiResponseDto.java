package io.vtou.vitamintou.domain.supplements.service.dto.res;

import lombok.*;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
public class NaverApiResponseDto {
    private String title;
    private String link;
    private String image;
    private String lprice;
    private String hprice;
    private String mallName;
    private String brand;
    private String maker;
    public NaverApiResponseDto(JSONObject itemJson){
        this.title=itemJson.getString("title");
        this.link=itemJson.getString("link");
        this.lprice=itemJson.getString("lprice");
        this.hprice=itemJson.getString("hprice");
        this.mallName=itemJson.getString("mallName");
        this.brand=itemJson.getString("brand");
        this.maker=itemJson.getString("maker");
        this.image=itemJson.getString("image");
    }
}
