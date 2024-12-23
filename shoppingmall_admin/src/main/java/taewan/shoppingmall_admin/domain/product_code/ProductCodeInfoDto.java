package taewan.shoppingmall_admin.domain.product_code;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductCodeInfoDto {

    private int id;
    private int parentId;
    private String name;
    private Character groupIndex;

}
