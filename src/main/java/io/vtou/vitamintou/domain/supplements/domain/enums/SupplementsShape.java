package io.vtou.vitamintou.domain.supplements.domain.enums;

import lombok.Getter;

@Getter
public enum SupplementsShape {
    LIQUID("액상"), GRANULES("과립"), POWDERS("분말"), CAPSULE("캡슐");

    private final String shape;

    SupplementsShape(String shape) {
        this.shape = shape;
    }
}