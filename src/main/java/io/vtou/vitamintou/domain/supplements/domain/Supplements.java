package io.vtou.vitamintou.domain.supplements.domain;

import io.vtou.vitamintou.domain.supplements.domain.enums.SupplementsShape;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Supplements {

    // 품목 제조 번호
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    // 품목명
    @Column(name = "name", nullable = false)
    private String name;

    // 업소명
    @Column(name = "company_name", nullable = false)
    private String companyName;

    // 소비기한 (제조 이후 개월수)
    @Column(name = "expiry_month", nullable = false)
    private Integer expiryMonth;

    // 보관 방법
    @Column(name = "storage_methods", nullable = false)
    private String storageMethods;

    // 주의 사항
    @Column(name = "caveats", nullable = false)
    private String caveats;

    // 성상
    @Column(name = "appearance", nullable = false)
    private String appearance;

    // 기준 규격
    @Column(name = "reference_standard", nullable = false)
    private String referenceStandard;

    // 효능
    @Column(name = "efficacy", nullable = false)
    private String efficacy;

    // 제품 형태
    @Enumerated(EnumType.STRING)
    @Column(name = "supplements_shape", nullable = false)
    private SupplementsShape supplementsShape;

    // 원재료
    @Column(name = "raw_materials", nullable = false)
    private String rawMaterials;

    // 데이터 생성 일자
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    // 데이터 최종 수정 일자
    @Column(name = "updated_at")
    private LocalDate updatedAt;

}
