package taewan.shoppingmall_admin.repository.product;

import taewan.shoppingmall_admin.entity.Product;

import java.util.List;

public interface ProductDSLRepository {

    List<Product> findAllByConditions(String where);

}
