package taewan.shoppingmall_admin.domain.product;

import java.util.List;

public interface ProductDSLRepository {

    List<Product> findAllByConditions(String where);

}
