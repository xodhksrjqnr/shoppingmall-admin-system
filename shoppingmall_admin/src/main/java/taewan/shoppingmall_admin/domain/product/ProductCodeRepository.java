package taewan.shoppingmall_admin.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCodeRepository extends JpaRepository<ProductCode, Integer> {

    List<ProductCode> findAllByParentId(int parentId);

}
