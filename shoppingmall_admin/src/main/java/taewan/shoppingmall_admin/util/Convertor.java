package taewan.shoppingmall_admin.util;

import taewan.shoppingmall_admin.domain.menu.dto.CategoryDto;
import taewan.shoppingmall_admin.domain.menu.Menu;
import taewan.shoppingmall_admin.domain.product.*;
import taewan.shoppingmall_admin.domain.product.dto.RequestAddProductDto;
import taewan.shoppingmall_admin.domain.product_code.ProductCode;
import taewan.shoppingmall_admin.domain.product_code.dto.ProductCodeInfoDto;
import taewan.shoppingmall_admin.domain.product_code.dto.RequestAddProductCodeDto;

public class Convertor {

    public static CategoryDto toCategoryDto(Menu entity) {
        return CategoryDto.builder()
                .name(entity.getName())
                .link(entity.getLink())
                .build();
    }

    public static ProductCodeInfoDto toProductCodeInfoDto(ProductCode entity) {
        return ProductCodeInfoDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .parentId(entity.getParentId())
                .groupIndex(entity.getGroupIndex())
                .build();
    }

    public static ProductCode toEntity(RequestAddProductCodeDto dto) {
        return ProductCode.create(dto.getParentId(), dto.getCode(), dto.getName(), dto.getGroupIndex());
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
