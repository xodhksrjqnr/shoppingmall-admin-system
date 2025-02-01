package taewan.shoppingmall_admin.domain.product_code;

import taewan.shoppingmall_admin.domain.product_code.dto.ProductCodeInfoDto;
import taewan.shoppingmall_admin.domain.product_code.dto.RequestAddProductCodeDto;

import java.util.List;

public interface ProductCodeService {

    List<ProductCodeInfoDto> searchAll();
    List<String> searchUnassignedAll();
    List<ProductCodeInfoDto> searchOneGroup(int parentId);
    void addOne(RequestAddProductCodeDto dto);

}
