package taewan.shoppingmall_admin.domain.product_code;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.domain.product_code.ProductCode;

import java.util.List;

public interface ProductCodeRepository extends JpaRepository<ProductCode, Integer> {

    List<ProductCode> findAllByParentId(int parentId);

}
