package taewan.shoppingmall_admin.domain.product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductInfoDto> searchAllWithFilter(RequestSearchProductDto dto);
    void addOne(RequestAddProductDto dto);

}
