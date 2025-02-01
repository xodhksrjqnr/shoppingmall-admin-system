package taewan.shoppingmall_admin.domain.product_code;

import taewan.shoppingmall_admin.domain.product_code.dto.ResponseUnassignedProductCode;

import java.util.List;

public interface ProductCodeDao {

    List<ResponseUnassignedProductCode> findUnassignedProductCodes();

}
