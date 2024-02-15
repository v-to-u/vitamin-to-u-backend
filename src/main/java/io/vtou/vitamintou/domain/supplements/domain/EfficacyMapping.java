package io.vtou.vitamintou.domain.supplements.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class EfficacyMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "supplements_id",nullable = false)
    private Long supplementsId;

    @Column(name="efficacys_id",nullable = false)
    private String efficacysId;
}
