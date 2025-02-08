package taewan.shoppingmall_admin.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.entity.Product;
import taewan.shoppingmall_admin.repository.product.ProductDSLRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>, ProductDSLRepository {
}
