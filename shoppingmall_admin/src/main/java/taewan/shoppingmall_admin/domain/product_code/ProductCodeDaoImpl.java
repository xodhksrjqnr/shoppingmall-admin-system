package taewan.shoppingmall_admin.domain.product_code;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import taewan.shoppingmall_admin.domain.product_code.dto.ResponseUnassignedProductCode;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductCodeDaoImpl implements ProductCodeDao {

    private final EntityManager entityManager;

    @Override
    public List<ResponseUnassignedProductCode> findUnassignedProductCodes() {
        String query = "select B.id as id, concat(A.code, '-', B.code) as code from product_code A " +
                "inner join (" +
                "    select B.id, A.parent_id, concat(A.code, '-', B.code) as code from product_code A " +
                "    inner join (" +
                "        select B.id, A.parent_id, concat(A.code, '-', B.code) as code from product_code A " +
                "        inner join (" +
                "            select B.id, A.parent_id, concat(A.code, '-', B.code) as code from product_code A " +
                "            inner join (select id, parent_id, code from product_code where assigned = 'n') B on A.id = B.parent_id " +
                "        ) B on A.id = B.parent_id " +
                "    ) B on A.id = B.parent_id " +
                ") B on A.id = B.parent_id";
        List<Object[]> resultList = this.entityManager.createNativeQuery(query).getResultList();

        return resultList
                .stream().map(obj -> new ResponseUnassignedProductCode((Integer) obj[0], (String) obj[1]))
                .collect(Collectors.toList());
    }

}
