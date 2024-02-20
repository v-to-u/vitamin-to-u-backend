package io.vtou.vitamintou.domain.supplements.infrastructure.provider;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@Getter
public class NaverApiClientProvider {
    private String clientId="";
    private String clientSecret="";
    public NaverApiClientProvider(@Value("${navershopping.client_id}") String clientId, @Value("${navershopping.client_secret}") String clientSecret){
        this.clientId=clientId;
        this.clientSecret=clientSecret;
    }
}
