package taewan.shoppingmall_admin.domain.product_code;

import taewan.shoppingmall_admin.domain.product_code.ProductCodeInfoDto;
import taewan.shoppingmall_admin.domain.product_code.RequestAddProductCodeDto;

import java.util.List;
import java.util.Map;

public interface ProductCodeService {

    Map<Character, List<ProductCodeInfoDto>> searchAll();
    List<ProductCodeInfoDto> searchOneGroup(int parentId);
    void addOne(RequestAddProductCodeDto dto);

}
