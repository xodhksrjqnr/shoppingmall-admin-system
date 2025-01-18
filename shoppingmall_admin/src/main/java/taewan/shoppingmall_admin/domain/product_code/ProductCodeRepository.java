package taewan.shoppingmall_admin.domain.product_code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import taewan.shoppingmall_admin.domain.product_code.ProductCode;

import java.util.List;

public interface ProductCodeRepository extends JpaRepository<ProductCode, Integer>, ProductCodeDao {

    List<ProductCode> findAllByParentId(int parentId);

}
