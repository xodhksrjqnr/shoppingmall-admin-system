package taewan.shoppingmall_admin.domain.product_code;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCodeDaoImpl implements ProductCodeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<String> findUnassignedProductCodes() {
        String query = "select concat(A.code, '-', B.code) as code from product_code A " +
                "inner join (" +
                "    select A.parent_id, concat(A.code, '-', B.code) as code from product_code A " +
                "    inner join (" +
                "        select A.parent_id, concat(A.code, '-', B.code) as code from product_code A " +
                "        inner join (" +
                "            select A.parent_id, concat(A.code, '-', B.code) as code from product_code A " +
                "            inner join (select parent_id, code from product_code where assigned = 'n') B on A.id = B.parent_id " +
                "        ) B on A.id = B.parent_id " +
                "    ) B on A.id = B.parent_id " +
                ") B on A.id = B.parent_id";
        return this.entityManager.createNativeQuery(query, List.class).getResultList();
    }

}
