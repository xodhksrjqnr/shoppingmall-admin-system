package taewan.shoppingmall_admin.dto.product_code;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductCodeInfoDto {

    private int id;
    private int parentId;
    private String code;
    private String name;
    private Character groupIndex;

}
