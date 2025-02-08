package taewan.shoppingmall_admin.service;

import taewan.shoppingmall_admin.dto.product.ProductInfoDto;
import taewan.shoppingmall_admin.dto.product.ProductInfoWithImageDto;
import taewan.shoppingmall_admin.dto.product.RequestAddProductDto;
import taewan.shoppingmall_admin.dto.product.RequestSearchProductDto;

import java.util.List;

public interface ProductService {

    List<ProductInfoDto> searchAllWithFilter(RequestSearchProductDto dto);
    ProductInfoWithImageDto searchOne(int productId);
    void addOne(RequestAddProductDto dto);

}
