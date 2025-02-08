package taewan.shoppingmall_admin.repository.product;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import taewan.shoppingmall_admin.entity.Product;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductDSLRepositoryImpl implements ProductDSLRepository {

    private final EntityManager entityManager;

    public List<Product> findAllByConditions(String where) {
        return entityManager
                .createQuery("select p from Product p" + (where.isEmpty() ? "" : where))
                .getResultList();
    }

}
