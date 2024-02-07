package io.vtou.vitamintou.domain.supplements.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SupplementsMaterial {
    ARGININE("아르기닌"), CA("칼슘"), DEER_ANTLERS("녹용"), FE("철분"), LACTO("유산균"), MG("마그네슘"), RED_GINSENG("홍삼농축액"),
    VITAMIN("비타민"), XYLITOL("자일리톨"), ZN("아연");

    private final String material;
}
