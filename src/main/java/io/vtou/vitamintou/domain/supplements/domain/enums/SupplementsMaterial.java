package io.vtou.vitamintou.domain.supplements.domain.enums;

import lombok.Getter;

@Getter
public enum SupplementsMaterial {
    RM_Arginine("아르기닌"), RM_Ca("칼슘"), RM_Deer_Antlers("녹용"), RM_Fe("철분"), RM_Lacto("유산균"), RM_Mg("마그네슘"), RM_Red_Ginseng("홍삼농축액"),
    RM_Vitamin("비타민"), RM_Xylitol("자일리톨"), RM_Zn("아연");

    private final String material;

    SupplementsMaterial(String material) {
        this.material = material;
    }
}
