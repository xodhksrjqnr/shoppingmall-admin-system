package taewan.shoppingmall_admin.domain.product;

import taewan.shoppingmall_admin.domain.product.dto.ProductInfoDto;
import taewan.shoppingmall_admin.domain.product.dto.RequestAddProductDto;
import taewan.shoppingmall_admin.domain.product.dto.RequestSearchProductDto;

import java.util.List;

public interface ProductService {

    List<ProductInfoDto> searchAllWithFilter(RequestSearchProductDto dto);
    void addOne(RequestAddProductDto dto);

}
