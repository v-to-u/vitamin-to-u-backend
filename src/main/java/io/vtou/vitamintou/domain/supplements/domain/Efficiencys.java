package io.vtou.vitamintou.domain.supplements.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Efficiencys {
    @Id
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name="name",nullable = false,unique = true)
    private String name;
}
