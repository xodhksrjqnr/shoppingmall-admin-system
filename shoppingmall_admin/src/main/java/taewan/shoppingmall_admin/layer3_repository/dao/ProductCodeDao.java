package taewan.shoppingmall_admin.layer3_repository.dao;

import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;

import java.util.List;

public interface ProductCodeDao {

    List<ResponseUnassignedProductCode> findUnassignedProductCodes();

}
