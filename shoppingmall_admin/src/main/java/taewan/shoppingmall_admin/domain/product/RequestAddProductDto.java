package taewan.shoppingmall_admin.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestAddProductDto {

    private String name;
    private String nameEng;
    private String code;
    private Integer sellingPrice;
    private Integer costPrice;
    private Integer stock;
    private String brand;
    private String placeOfOrigin;

}
