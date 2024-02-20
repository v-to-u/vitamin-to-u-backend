package io.vtou.vitamintou.domain.supplements.service;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.supplements.exception.SupplementsException;
import io.vtou.vitamintou.domain.supplements.service.dto.res.NaverApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ShoppingService {
    @Value("${navershopping.client_id}")
    private String clientId;

    @Value("${navershopping.client_secret}")
    private String clientSecret;

    public NaverApiResponseDto search(String text) {
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/shop.json")
                .queryParam("query", text)
                .queryParam("display", 1)
                .queryParam("start", 1)
                .queryParam("sort", "sim")
                .encode()
                .build()
                .toUri();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange(req, String.class);

        JSONObject rjson = new JSONObject(resp.getBody());

        JSONArray array = rjson.getJSONArray("items");

        if (array.isEmpty()) return null;
        else {
            JSONObject supplements = (JSONObject) array.get(0);
            return new NaverApiResponseDto(supplements);
        }
    }
}
