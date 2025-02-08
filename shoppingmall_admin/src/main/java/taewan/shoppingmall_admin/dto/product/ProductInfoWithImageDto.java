package taewan.shoppingmall_admin.dto.product;

import lombok.Getter;
import taewan.shoppingmall_admin.base.entity.Product;
import taewan.shoppingmall_admin.base.entity.ProductImage;

import java.util.List;

@Getter
public class ProductInfoWithImageDto extends ProductInfoDto {

    private final List<String> productImages;

    public ProductInfoWithImageDto(Product entity, List<ProductImage> images) {
        super(entity);
        this.productImages = images.stream().map(ProductImage::getName).toList();
    }
}
