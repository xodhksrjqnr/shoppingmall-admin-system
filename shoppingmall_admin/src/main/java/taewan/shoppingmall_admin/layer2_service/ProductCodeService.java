package taewan.shoppingmall_admin.layer2_service;

import taewan.shoppingmall_admin.dto.AllInfoDto;
import taewan.shoppingmall_admin.dto.product_code.ProductCodeInfoDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;

import java.util.List;

public interface ProductCodeService {

    List<ResponseUnassignedProductCode> searchUnassignedAll();
    List<ProductCodeInfoDto> searchOneGroup(int parentId);
    void addOne(RequestAddProductCodeDto dto);

}
