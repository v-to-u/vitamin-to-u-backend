package io.vtou.vitamintou.domain.supplements.domain.enums;

import lombok.Getter;

@Getter
public enum SupplementsEfficiency {
    Effi_Antioxidants("항산화"), Effi_Blood("혈액"), Effi_Body_Fat("체지방"), Effi_Bone("뼈"), Effi_Bowel("장건강"),
    Effi_Cholesterol("콜레스테롤"), Effi_Energy("에너지"), Effi_Fatigue("피로회복"), Effi_Immunity("면역"), Effi_Liver("간"), Effi_Memory("기억"),
    Effi_Muscle("근육"), Effi_Nerves("신경"), Effi_Osteolysis("골다골증"), Effi_Skin("피부"), Effi_Stress("스트레스"), Effi_Teeth("치아"),
    Effi_Menopause("갱년기"), Effi_Platelets("혈소판");

    private final String efficiency;

    SupplementsEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
