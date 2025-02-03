package taewan.shoppingmall_admin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.domain.brand.BrandInfoDto;
import taewan.shoppingmall_admin.domain.brand.BrandService;
import taewan.shoppingmall_admin.domain.brand.dto.RequestAddBrandDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandApiController {

    private final BrandService brandService;

    @GetMapping("/all")
    public List<BrandInfoDto> allOfBrand() {
        return brandService.searchAll();
    }

    @PostMapping
    public void addBrand(@RequestBody RequestAddBrandDto dto) {
        brandService.addOne(dto);
    }

}
