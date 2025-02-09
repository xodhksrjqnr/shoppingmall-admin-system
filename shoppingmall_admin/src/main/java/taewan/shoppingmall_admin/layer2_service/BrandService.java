package taewan.shoppingmall_admin.layer2_service;

import taewan.shoppingmall_admin.dto.brand.BrandDto;
import taewan.shoppingmall_admin.dto.brand.RequestAddBrandDto;

import java.util.List;

public interface BrandService {

    List<BrandDto> searchAll();
    void addOne(RequestAddBrandDto dto);

}
