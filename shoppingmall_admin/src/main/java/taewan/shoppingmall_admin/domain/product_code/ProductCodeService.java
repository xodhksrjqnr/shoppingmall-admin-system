package taewan.shoppingmall_admin.domain.product_code;

import java.util.List;

public interface ProductCodeService {

    List<ProductCodeInfoDto> searchAll();
    List<String> searchUnassignedAll();
    List<ProductCodeInfoDto> searchOneGroup(int parentId);
    void addOne(RequestAddProductCodeDto dto);

}
