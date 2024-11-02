package taewan.shoppingmall_admin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.domain.product.ProductElementService;
import taewan.shoppingmall_admin.domain.product.RequestAddProductElementDto;
import taewan.shoppingmall_admin.domain.product.ResponseProductElements;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductElementService productService;

    @GetMapping("/elements/all")
    public ResponseProductElements allGroupOfProductElements() {
        return new ResponseProductElements(productService.searchAll());
    }

    @GetMapping("/elements/sub")
    public ResponseProductElements oneGroupOfProductElements(@RequestParam Integer parentId) {
        return new ResponseProductElements(productService.searchOneGroup(parentId));
    }

    @PostMapping("/elements")
    public void addProductElement(@RequestBody RequestAddProductElementDto addDto) {
        productService.addOne(addDto);
    }

}
