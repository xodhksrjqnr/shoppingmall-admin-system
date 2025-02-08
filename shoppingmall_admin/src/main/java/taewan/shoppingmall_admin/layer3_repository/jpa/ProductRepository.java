package taewan.shoppingmall_admin.layer3_repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.base.entity.Product;
import taewan.shoppingmall_admin.layer3_repository.dao.ProductDSLRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>, ProductDSLRepository {
}
