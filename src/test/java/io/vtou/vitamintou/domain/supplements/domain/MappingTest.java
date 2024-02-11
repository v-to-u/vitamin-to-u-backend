package io.vtou.vitamintou.domain.supplements.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Mapping Entity")
class MappingTest {
    @Test
    void testMappingEntityCreate(){
        // Arange
        String expected_categoryId="test,test1,test2";
        Long expected_supplementsId=(long)1;

        // Act
        var actualResult=EfficacyMapping.builder()
                .efficacysId(expected_categoryId)
                .supplementsId(expected_supplementsId)
                .build();

        // Assert
        Assertions.assertThat(actualResult)
                .hasFieldOrPropertyWithValue("efficacysId",expected_categoryId)
                .hasFieldOrPropertyWithValue("supplementsId",expected_supplementsId);
    }
}
