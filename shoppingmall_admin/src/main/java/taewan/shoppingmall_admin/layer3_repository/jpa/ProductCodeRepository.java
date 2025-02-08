package taewan.shoppingmall_admin.layer3_repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.base.entity.ProductCode;
import taewan.shoppingmall_admin.layer3_repository.dao.ProductCodeDao;

import java.util.List;
import java.util.Optional;

public interface ProductCodeRepository extends JpaRepository<ProductCode, Integer>, ProductCodeDao {

    List<ProductCode> findAllByParentId(int parentId);
    Optional<ProductCode> findByIdAndAssigned(int id, char assigned);

}
