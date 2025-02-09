package taewan.shoppingmall_admin.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ProductDto {

    private final int id;
    private final String name;
    private final String nameEng;
    private final String code;
    private final String sellingPrice;
    private final String costPrice;
    private final Integer stock;
    private final String brand;
    private final String placeOfOrigin;
    private final LocalDateTime createdDate;

}
