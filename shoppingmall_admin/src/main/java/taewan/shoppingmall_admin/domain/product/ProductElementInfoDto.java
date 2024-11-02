package taewan.shoppingmall_admin.domain.product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductElementInfoDto {

    private int id;
    private int parentId;
    private String name;
    private Character groupIndex;

}
