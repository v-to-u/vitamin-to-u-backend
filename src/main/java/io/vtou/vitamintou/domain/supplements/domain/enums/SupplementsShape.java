package io.vtou.vitamintou.domain.supplements.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum SupplementsShape {
    LIQUID("액상"), GRANULES("과립"), POWDERS("분말"), CAPSULE("캡슐"), CAPSAL("캅셀"), CONCENTRATE("농축액"), REFINE("정제"), PILL("환");

    private final String shape;

    SupplementsShape(String shape) {
        this.shape = shape;
    }
}
