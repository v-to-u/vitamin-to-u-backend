package io.vtou.vitamintou.mapper;

import io.vtou.vitamintou.domain.supplements.service.dto.req.SupplementsCreateRequestDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplementsMapper {
    @Insert(value = "INSERT INTO Vtou.:efficiency VALUES (#{createdAt},#{updatedAt},#{id},#{caveats},#{efficacy}," +
            "#{rawMaterials},#{referenceStandard},#{storageMethods},#{appearance},#{companyName},#{expiryMonth}," +
            "#{name},#{supplementsShape})")
    void insertSupplements(SupplementsCreateRequestDto supplementsCreateRequestDto,String efficiency);
}
