package taewan.shoppingmall_admin.dto.product_code;

import lombok.Builder;
import lombok.Getter;
import taewan.shoppingmall_admin.dto.AllInfoDto;

@Getter
@Builder
public class ProductCodeInfoDto extends AllInfoDto {

    private int id;
    private int parentId;
    private String code;
    private String name;
    private Character groupIndex;

}
