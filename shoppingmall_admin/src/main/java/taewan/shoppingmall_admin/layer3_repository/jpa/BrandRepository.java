package taewan.shoppingmall_admin.layer3_repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.base.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByCode(String code);

}
