package taewan.shoppingmall_admin.repository.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByCode(String code);

}
