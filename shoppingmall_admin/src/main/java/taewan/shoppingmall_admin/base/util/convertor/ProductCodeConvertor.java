package taewan.shoppingmall_admin.base.util.convertor;

import taewan.shoppingmall_admin.base.entity.ProductCode;
import taewan.shoppingmall_admin.dto.product_code.ProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;

public class ProductCodeConvertor {

    public static ProductCode convert(RequestAddProductCodeDto dto) {
        return ProductCode.create(
                dto.getParentId(),
                dto.getCode(),
                dto.getName(),
                dto.getGroupIndex()
        );
    }

    public static ProductCodeDto convert(ProductCode entity) {
        return ProductCodeDto.builder()
                .id(entity.getId())
                .parentId(entity.getParentId())
                .code(entity.getCode())
                .name(entity.getName())
                .groupIndex(entity.getGroupIndex())
                .build();
    }

}
