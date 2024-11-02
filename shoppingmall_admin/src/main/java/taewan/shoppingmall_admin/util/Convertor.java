package taewan.shoppingmall_admin.util;

import taewan.shoppingmall_admin.domain.menu.CategoryDto;
import taewan.shoppingmall_admin.domain.menu.Menu;
import taewan.shoppingmall_admin.domain.product.ProductCode;
import taewan.shoppingmall_admin.domain.product.ProductCodeInfoDto;
import taewan.shoppingmall_admin.domain.product.RequestAddProductCodeDto;

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

}
