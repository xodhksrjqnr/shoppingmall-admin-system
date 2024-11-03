package taewan.shoppingmall_admin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.domain.product.ProductCodeService;
import taewan.shoppingmall_admin.domain.product.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.domain.product.ResponseProductCodes;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-codes")
public class ProductCodeApiController {

    private final ProductCodeService productService;

    @GetMapping("/all")
    public ResponseProductCodes allGroupOfProductCodes() {
        return new ResponseProductCodes(productService.searchAll());
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
