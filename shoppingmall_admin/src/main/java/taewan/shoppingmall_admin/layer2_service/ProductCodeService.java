package taewan.shoppingmall_admin.layer2_service;

import taewan.shoppingmall_admin.dto.product_code.ProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;

import java.util.List;

public interface ProductCodeService {

    List<ProductCodeDto> searchAll();
    List<ResponseUnassignedProductCode> searchUnassignedAll();
    List<ProductCodeDto> searchOneGroup(int parentId);
    void addOne(RequestAddProductCodeDto dto);

}
