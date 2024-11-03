package taewan.shoppingmall_admin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taewan.shoppingmall_admin.domain.product.ProductInfoDto;
import taewan.shoppingmall_admin.domain.product.ProductService;
import taewan.shoppingmall_admin.domain.product.RequestAddProductDto;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/all")
    public Map<String, List<ProductInfoDto>> allOfProducts() {
        return Map.of("Products", productService.searchAllWithFilter());
    }

    @PostMapping
    public void addProduct(RequestAddProductDto dto) {
        productService.addOne(dto);
    }

}
