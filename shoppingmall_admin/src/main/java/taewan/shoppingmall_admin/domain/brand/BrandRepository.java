package taewan.shoppingmall_admin.domain.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByCode(String code);

}
