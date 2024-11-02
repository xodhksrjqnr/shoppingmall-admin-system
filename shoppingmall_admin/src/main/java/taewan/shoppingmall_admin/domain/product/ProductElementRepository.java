package taewan.shoppingmall_admin.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductElementRepository extends JpaRepository<ProductElement, Integer> {

    List<ProductElement> findAllByParentId(int parentId);

}