package taewan.shoppingmall_admin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.domain.product_code.ProductCodeService;
import taewan.shoppingmall_admin.domain.product_code.dto.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.domain.product_code.dto.ResponseProductCodes;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-codes")
public class ProductCodeApiController {

    private final ProductCodeService productService;

    @GetMapping
    public ResponseProductCodes allProductCodes() {
        return new ResponseProductCodes(productService.searchAll());
    }

    @GetMapping("/unassigned")
    public List<String> allUnassignedProductCodes() {
        return productService.searchUnassignedAll();
    }

    @GetMapping("/sub")
    public ResponseProductCodes oneGroupOfProductCodes(@RequestParam Integer parentId) {
        return new ResponseProductCodes(productService.searchOneGroup(parentId));
    }

    @PostMapping
    public void addProductCode(@RequestBody RequestAddProductCodeDto addDto) {
        productService.addOne(addDto);
    }

}
