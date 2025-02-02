package taewan.shoppingmall_admin.domain.product.dto;

import lombok.Getter;
import taewan.shoppingmall_admin.domain.product.Product;
import taewan.shoppingmall_admin.domain.product.ProductImage;

import java.util.List;

@Getter
public class ProductInfoWithImageDto extends ProductInfoDto {

    private final List<String> productImages;

    public ProductInfoWithImageDto(Product entity, List<ProductImage> images) {
        super(entity);
        this.productImages = images.stream().map(ProductImage::getName).toList();
    }
}
