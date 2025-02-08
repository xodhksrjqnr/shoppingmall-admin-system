package taewan.shoppingmall_admin.repository.product_code;

import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;

import java.util.List;

public interface ProductCodeDao {

    List<ResponseUnassignedProductCode> findUnassignedProductCodes();

}
