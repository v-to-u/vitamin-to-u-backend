package io.vtou.vitamintou.domain.supplements.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test Supplements Entity")
class SupplementTest {

    @Test
    void testCreateSupplementEntity(){
        // Arange
        Long expect_id=(long)1;
        String expect_appearance="캅셀";
        String expect_cavests="물";
        String expect_company_name="고려";
        String expect_efficacy="뼈와 치아";
        String expect_expiry_month="2년";
        String expect_name="영양칼슌비타민";
        String expect_raw_materials="비타민";
        String expect_reference_standard="성상";
        String expect_storage_method="";
        String expect_supplements_shape="";

        // Act
        var actualResult=Supplements.builder()
                .id(expect_id)
                .caveats(expect_cavests)
                .appearance(expect_appearance)
                .companyName(expect_company_name)
                .efficacy(expect_efficacy)
                .expiryMonth(expect_expiry_month)
                .name(expect_name)
                .rawMaterials(expect_raw_materials)
                .referenceStandard(expect_reference_standard)
                .storageMethods(expect_storage_method)
                .supplementsShape(expect_supplements_shape)
                .build();

        // Assert
        assertThat(actualResult)
                .hasFieldOrPropertyWithValue("id",expect_id)
                .hasFieldOrPropertyWithValue("caveats",expect_cavests)
                .hasFieldOrPropertyWithValue("appearance",expect_appearance)
                .hasFieldOrPropertyWithValue("companyName",expect_company_name)
                .hasFieldOrPropertyWithValue("efficacy",expect_efficacy)
                .hasFieldOrPropertyWithValue("expiryMonth",expect_expiry_month)
                .hasFieldOrPropertyWithValue("name",expect_name)
                .hasFieldOrPropertyWithValue("rawMaterials",expect_raw_materials)
                .hasFieldOrPropertyWithValue("referenceStandard",expect_reference_standard)
                .hasFieldOrPropertyWithValue("storageMethods",expect_storage_method)
                .hasFieldOrPropertyWithValue("supplementsShape",expect_supplements_shape);
    }
}
