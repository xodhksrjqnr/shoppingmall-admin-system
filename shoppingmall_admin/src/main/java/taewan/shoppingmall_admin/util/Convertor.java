package taewan.shoppingmall_admin.util;

import taewan.shoppingmall_admin.domain.menu.CategoryDto;
import taewan.shoppingmall_admin.domain.menu.Menu;
import taewan.shoppingmall_admin.domain.product.ProductElement;
import taewan.shoppingmall_admin.domain.product.ProductElementInfoDto;
import taewan.shoppingmall_admin.domain.product.RequestAddProductElementDto;

public class Convertor {

    public static CategoryDto toCategoryDto(Menu entity) {
        return CategoryDto.builder()
                .name(entity.getName())
                .link(entity.getLink())
                .build();
    }

    public static ProductElementInfoDto toProductElementInfoDto(ProductElement entity) {
        return ProductElementInfoDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentId(entity.getParentId())
                .groupIndex(entity.getGroupIndex())
                .build();
    }

    public static ProductElement toEntity(RequestAddProductElementDto dto) {
        return ProductElement.create(dto.getParentId(), dto.getName(), dto.getGroupIndex());
    }

}
