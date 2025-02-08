package taewan.shoppingmall_admin.dto.product_code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestAddProductCodeDto {

    private int parentId;
    private String code;
    private String name;
    private Character groupIndex;

}
