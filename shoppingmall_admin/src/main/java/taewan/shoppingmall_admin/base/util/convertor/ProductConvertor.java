package taewan.shoppingmall_admin.base.util.convertor;

import taewan.shoppingmall_admin.base.entity.Product;
import taewan.shoppingmall_admin.base.entity.ProductImage;
import taewan.shoppingmall_admin.dto.product.ProductDto;
import taewan.shoppingmall_admin.dto.product.ProductInfoWithImageDto;
import taewan.shoppingmall_admin.dto.product.RequestAddProductDto;

import java.util.List;

public class ProductConvertor {

    public static Product convert(RequestAddProductDto dto) {
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

    public static ProductDto convert(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .nameEng(entity.getNameEng())
                .code(entity.getCode())
                .sellingPrice(entity.getSellingPrice())
                .costPrice(entity.getCostPrice())
                .stock(entity.getStock())
                .brand(entity.getBrand())
                .placeOfOrigin(entity.getPlaceOfOrigin())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public static ProductInfoWithImageDto convert(Product entity, List<ProductImage> images) {
        return ProductInfoWithImageDto.builder()
                .dto(ProductConvertor.convert(entity))
                .images(images.stream().map(ProductImage::getName).toList())
                .build();
    }

}
