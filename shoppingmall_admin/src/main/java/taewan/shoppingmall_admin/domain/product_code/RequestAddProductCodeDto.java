package taewan.shoppingmall_admin.domain.product_code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestAddProductCodeDto {

    private int parentId;
    private String name;
    private Character groupIndex;

}
