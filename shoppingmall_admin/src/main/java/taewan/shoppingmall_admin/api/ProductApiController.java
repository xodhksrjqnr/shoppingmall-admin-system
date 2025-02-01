package taewan.shoppingmall_admin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.domain.product.dto.ProductInfoDto;
import taewan.shoppingmall_admin.domain.product.ProductService;
import taewan.shoppingmall_admin.domain.product.dto.RequestAddProductDto;
import taewan.shoppingmall_admin.domain.product.dto.RequestSearchProductDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<ProductInfoDto> allOfProducts(@ModelAttribute RequestSearchProductDto dto) {
        return productService.searchAllWithFilter(dto);
    }

    @PostMapping
    public void addProduct(@RequestBody RequestAddProductDto dto) {
        productService.addOne(dto);
    }

}
