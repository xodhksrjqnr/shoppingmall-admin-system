package taewan.shoppingmall_admin.dto.product;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductInfoWithImageDto {

    private final ProductDto product;
    private final List<String> productImages;

    @Builder
    public ProductInfoWithImageDto(ProductDto dto, List<String> images) {
        this.product = dto;
        this.productImages = images;
    }
}
