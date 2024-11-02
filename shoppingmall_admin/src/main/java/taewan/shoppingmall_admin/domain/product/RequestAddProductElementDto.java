package taewan.shoppingmall_admin.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestAddProductElementDto {

    private int parentId;
    private String name;
    private Character groupIndex;

}
