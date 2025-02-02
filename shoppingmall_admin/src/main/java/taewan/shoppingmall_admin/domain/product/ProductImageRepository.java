package taewan.shoppingmall_admin.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    List<ProductImage> findAllByProductId(int productId);

}
