package taewan.shoppingmall_admin.repository.productimage;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.entity.ProductImage;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    List<ProductImage> findAllByProductId(int productId);

}
