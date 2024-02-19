package io.vtou.vitamintou.domain.supplements.domain;

import io.vtou.vitamintou.domain.supplements.service.SupplementsCommonService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@DisplayName("supplements return test")
class MakeSupplementTest {

    @Autowired
    private SupplementsCommonService supplementsCommonService;

    @Test
    void supplementEntityReturnTest(){
        Long expected_id=200400150704L;

        var actualResult= supplementsCommonService.makeSupplement(expected_id);

        Assertions.assertThat(actualResult)
                .isNotNull();
    }
}
