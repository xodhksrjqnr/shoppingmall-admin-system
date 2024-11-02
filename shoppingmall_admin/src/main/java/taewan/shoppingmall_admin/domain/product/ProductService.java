package taewan.shoppingmall_admin.domain.product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<Character, List<ProductElementInfoDto>> searchAll();
    List<ProductElementInfoDto> searchOneGroup(int parentId);
    void addOne(RequestAddProductElementDto dto);

}
