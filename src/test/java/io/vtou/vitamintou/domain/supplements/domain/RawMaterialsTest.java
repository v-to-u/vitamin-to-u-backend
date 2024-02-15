package io.vtou.vitamintou.domain.supplements.domain;

import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsMaterial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test RawMaterials Entity")
class RawMaterialsTest {
    @Test
    void testRawMaterialsEntityCreate(){
        // Arange
        String expected_id= SupplementsMaterial.valueOf("CA").toString();
        String expected_name =SupplementsMaterial.CA.getMaterial();

        // Act
        var actualResult=RawMaterials.builder()
                .id(expected_id)
                .name(expected_name)
                .build();

        // Assert
        assertThat(actualResult)
                .hasFieldOrPropertyWithValue("id",expected_id)
                .hasFieldOrPropertyWithValue("name",expected_name);
    }

//    void testRawMaterialsEntityFailExists(){
//
//    }
}
