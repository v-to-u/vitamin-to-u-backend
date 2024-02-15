package io.vtou.vitamintou.domain.supplements.domain;

import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsEfficiency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Efficacys Entity")
class EfficacysTest {
    @Test
    void testCreateEfficacysEntity(){
        // Arange
        String expected_id= SupplementsEfficiency.valueOf("BONE").toString();
        String expected_name=SupplementsEfficiency.BONE.getEfficiency();

        // Act
        var actualResult=Efficacys.builder()
                .id(expected_id)
                .name(expected_name)
                .build();

        // Assert
        Assertions.assertThat(actualResult)
                .hasFieldOrPropertyWithValue("id",expected_id)
                .hasFieldOrPropertyWithValue("name",expected_name);
    }
}
