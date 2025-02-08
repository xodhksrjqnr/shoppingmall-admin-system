package taewan.shoppingmall_admin.layer3_repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.base.entity.ProductImage;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    List<ProductImage> findAllByProductId(int productId);

}
