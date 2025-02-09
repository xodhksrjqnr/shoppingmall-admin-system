package taewan.shoppingmall_admin.layer1_api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.dto.brand.BrandDto;
import taewan.shoppingmall_admin.dto.brand.RequestAddBrandDto;
import taewan.shoppingmall_admin.layer2_service.BrandService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandApiController {

    private final BrandService brandService;

    @GetMapping("/all")
    public List<BrandDto> allOfBrand() { return brandService.searchAll(); }

    @PostMapping
    public void addBrand(@RequestBody RequestAddBrandDto dto) {
        brandService.addOne(dto);
    }

}
