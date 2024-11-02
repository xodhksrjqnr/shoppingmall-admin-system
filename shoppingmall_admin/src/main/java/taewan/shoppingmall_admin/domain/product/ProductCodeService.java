package taewan.shoppingmall_admin.domain.product;

import java.util.List;
import java.util.Map;

public interface ProductCodeService {

    Map<Character, List<ProductCodeInfoDto>> searchAll();
    List<ProductCodeInfoDto> searchOneGroup(int parentId);
    void addOne(RequestAddProductCodeDto dto);

}
