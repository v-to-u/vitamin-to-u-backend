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

    @ManyToOne
    @JoinColumn(name = "supplements_id")
    private Supplements supplements;

    @ManyToOne
    @JoinColumn(name = "rawMaterial_id")
    private RawMaterials rawMaterials;
}
