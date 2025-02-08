package taewan.shoppingmall_admin.layer3_repository.dao;

import taewan.shoppingmall_admin.base.entity.Product;

import java.util.List;

public interface ProductDSLRepository {

    List<Product> findAllByConditions(String where);

}
