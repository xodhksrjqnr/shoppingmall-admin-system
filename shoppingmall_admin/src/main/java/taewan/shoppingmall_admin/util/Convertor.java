package taewan.shoppingmall_admin.util;

import taewan.shoppingmall_admin.entity.Brand;
import taewan.shoppingmall_admin.dto.brand.RequestAddBrandDto;
import taewan.shoppingmall_admin.dto.menu.CategoryDto;
import taewan.shoppingmall_admin.entity.Menu;
import taewan.shoppingmall_admin.dto.product.RequestAddProductDto;
import taewan.shoppingmall_admin.entity.ProductCode;
import taewan.shoppingmall_admin.dto.product_code.ProductCodeInfoDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.entity.Product;

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

    public static Brand toEntity(RequestAddBrandDto dto) {
        return Brand.create(dto.getName(), dto.getCode());
    }

}
