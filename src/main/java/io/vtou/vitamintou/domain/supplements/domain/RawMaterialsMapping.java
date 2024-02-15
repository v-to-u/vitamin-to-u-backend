package io.vtou.vitamintou.domain.supplements.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RawMaterialsMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "supplements_id")
    private Long supplementsId;

    @Column(name = "rawMaterial_id")
    private String rawMaterialsId;
}
