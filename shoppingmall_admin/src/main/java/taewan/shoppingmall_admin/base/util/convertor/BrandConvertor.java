package taewan.shoppingmall_admin.base.util.convertor;

import taewan.shoppingmall_admin.base.entity.Brand;
import taewan.shoppingmall_admin.dto.brand.BrandDto;
import taewan.shoppingmall_admin.dto.brand.RequestAddBrandDto;

public class BrandConvertor {

    public static Brand convert(RequestAddBrandDto dto) {
        return Brand.create(dto.getName(), dto.getCode());
    }

    public static BrandDto convert(Brand entity) {
        return BrandDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
