package taewan.shoppingmall_admin.dto.product_code;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductCodeDto {

    private int id;
    private int parentId;
    private String code;
    private String name;
    private Character groupIndex;

}
