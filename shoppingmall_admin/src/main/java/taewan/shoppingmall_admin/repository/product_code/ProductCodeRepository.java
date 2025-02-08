package taewan.shoppingmall_admin.repository.product_code;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.entity.ProductCode;

import java.util.List;
import java.util.Optional;

public interface ProductCodeRepository extends JpaRepository<ProductCode, Integer>, ProductCodeDao {

    List<ProductCode> findAllByParentId(int parentId);
    Optional<ProductCode> findByIdAndAssigned(int id, char assigned);

}
