package taewan.shoppingmall_admin.domain.product_code;

import java.util.List;

public interface ProductCodeDao {

    List<String> findUnassignedProductCodes();

}
