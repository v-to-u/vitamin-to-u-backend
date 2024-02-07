package io.vtou.vitamintou.domain.supplements.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SupplementsEfficiency {
    ANTIOXI("항산화"), BLOOD("혈액"), BODY_FAT("체지방"), BONE("뼈"), BOWEL("장건강"),
    CHOLESTEROL("콜레스테롤"), ENERGY("에너지"), FATIGUE("피로회복"), IMMUNITY("면역"), LIVER("간"), MERMORY("기억"),
    MUSCLE("근육"), NERVES("신경"), OSTEOLYSIS("골다골증"), SKIN("피부"), STRESS("스트레스"), TEETH("치아"),
    MENOPAUSE("갱년기"),PLATELETS("혈소판");

    private final String efficiency;
}
