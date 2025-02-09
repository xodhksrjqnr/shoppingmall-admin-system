package taewan.shoppingmall_admin.layer1_api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.dto.product_code.ProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.ResponseProductCodes;
import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;
import taewan.shoppingmall_admin.layer2_service.ProductCodeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-codes")
public class ProductCodeApiController {

    private final ProductCodeService productCodeService;

    @GetMapping
    public List<ProductCodeDto> allOfProductCode() {
        return productCodeService.searchAll();
    }

    @GetMapping("/unassigned")
    public List<ResponseUnassignedProductCode> allUnassignedProductCodes() {
        return productCodeService.searchUnassignedAll();
    }

    @GetMapping("/sub")
    public ResponseProductCodes oneGroupOfProductCodes(@RequestParam Integer parentId) {
        return new ResponseProductCodes(productCodeService.searchOneGroup(parentId));
    }

    @PostMapping
    public void addProductCode(@RequestBody RequestAddProductCodeDto addDto) {
        productCodeService.addOne(addDto);
    }

}
