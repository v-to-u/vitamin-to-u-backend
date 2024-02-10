package io.vtou.vitamintou.domain.supplements.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class EfficiencyMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplements_id")
    private Supplements supplements;

    @ManyToOne
    @JoinColumn(name="efficiencys_id")
    private Efficiencys efficiencys;
}
