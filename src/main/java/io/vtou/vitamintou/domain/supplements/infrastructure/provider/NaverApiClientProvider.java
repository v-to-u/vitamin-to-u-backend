package io.vtou.vitamintou.domain.supplements.infrastructure.provider;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NaverApiClientProvider {
    private final String clientId;
    private final String clientSecret;
    public NaverApiClientProvider(@Value("${navershopping.client_id}") String cliendId,@Value("${navershopping.client_secret}") String clientSecret){
        this.clientId=cliendId;
        this.clientSecret=clientSecret;
    }
}
