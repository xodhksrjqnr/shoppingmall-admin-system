package taewan.shoppingmall_admin.layer2_service;

import taewan.shoppingmall_admin.dto.product.ProductDto;
import taewan.shoppingmall_admin.dto.product.ProductInfoWithImageDto;
import taewan.shoppingmall_admin.dto.product.RequestAddProductDto;
import taewan.shoppingmall_admin.dto.product.RequestSearchProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> searchAllWithFilter(RequestSearchProductDto dto);
    ProductInfoWithImageDto searchOne(int productId);
    void addOne(RequestAddProductDto dto);

}
