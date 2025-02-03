package taewan.shoppingmall_admin.domain.brand;

import taewan.shoppingmall_admin.domain.brand.dto.RequestAddBrandDto;

import java.util.List;

public interface BrandService {

    List<BrandInfoDto> searchAll();
    void addOne(RequestAddBrandDto dto);

}
