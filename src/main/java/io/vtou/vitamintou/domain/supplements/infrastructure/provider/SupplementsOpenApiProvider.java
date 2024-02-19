package io.vtou.vitamintou.domain.supplements.infrastructure.provider;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SupplementsOpenApiProvider {

    private final WebClient webClient;

    public SupplementsOpenApiProvider(@Value("${supplements.secret-key}") String secretKey) {
        this.webClient = WebClient.builder()
            .baseUrl("https://openapi.foodsafetykorea.go.kr/api/" + secretKey + "/C003/json/1/20/")
            .build();
    }

    public JSONObject requestAllSupplementsDataApi() {
        return webClient.get().accept(MediaType.APPLICATION_JSON).retrieve()
            .bodyToMono(String.class).map(JSONObject::new).block();
    }
}
