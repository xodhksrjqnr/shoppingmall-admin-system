package taewan.shoppingmall_admin.util;

import taewan.shoppingmall_admin.domain.menu.CategoryDto;
import taewan.shoppingmall_admin.domain.menu.Menu;
import taewan.shoppingmall_admin.domain.product.*;

public class Convertor {

    public static CategoryDto toCategoryDto(Menu entity) {
        return CategoryDto.builder()
                .name(entity.getName())
                .link(entity.getLink())
                .build();
    }

    public static ProductCodeInfoDto toProductElementInfoDto(ProductCode entity) {
        return ProductCodeInfoDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentId(entity.getParentId())
                .groupIndex(entity.getGroupIndex())
                .build();
    }

    public static ProductCode toEntity(RequestAddProductCodeDto dto) {
        return ProductCode.create(dto.getParentId(), dto.getName(), dto.getGroupIndex());
    }

    public static Product toEntity(RequestAddProductDto dto) {
        return Product.create(
                dto.getName(),
                dto.getNameEng(),
                dto.getCode(),
                dto.getSellingPrice(),
                dto.getCostPrice(),
                dto.getStock(),
                dto.getBrand(),
                dto.getPlaceOfOrigin()
        );
    }

}
