package taewan.shoppingmall_admin.layer3_repository.dao;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import taewan.shoppingmall_admin.base.entity.Product;

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
