package taewan.shoppingmall_admin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.dto.product.ProductInfoDto;
import taewan.shoppingmall_admin.service.ProductService;
import taewan.shoppingmall_admin.dto.product.ProductInfoWithImageDto;
import taewan.shoppingmall_admin.dto.product.RequestAddProductDto;
import taewan.shoppingmall_admin.dto.product.RequestSearchProductDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductService productService;

    @GetMapping
    public ProductInfoWithImageDto oneOfProduct(@RequestParam Integer id) {
        return productService.searchOne(id);
    }

    @GetMapping("/all")
    public List<ProductInfoDto> allOfProduct(@ModelAttribute RequestSearchProductDto dto) {
        return productService.searchAllWithFilter(dto);
    }

    @PostMapping
    public void addProduct(@RequestBody RequestAddProductDto dto) {
        productService.addOne(dto);
    }

}
