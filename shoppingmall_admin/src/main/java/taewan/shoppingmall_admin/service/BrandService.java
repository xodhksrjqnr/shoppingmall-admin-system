package taewan.shoppingmall_admin.service;

import taewan.shoppingmall_admin.dto.brand.BrandInfoDto;
import taewan.shoppingmall_admin.dto.brand.RequestAddBrandDto;

import java.util.List;

public interface BrandService {

    List<BrandInfoDto> searchAll();
    void addOne(RequestAddBrandDto dto);

}
