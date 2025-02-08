package taewan.shoppingmall_admin.layer1_api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taewan.shoppingmall_admin.dto.AllInfoDto;
import taewan.shoppingmall_admin.layer2_service.BasicService;
import taewan.shoppingmall_admin.layer2_service.ProductCodeService;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.ResponseProductCodes;
import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-codes")
public class ProductCodeApiController {

    private final BasicService basicService;
    private final ProductCodeService productService;

    @GetMapping
    public List<AllInfoDto> allOfProductCode() {
        return basicService.searchAll("productCode");
    }

    @GetMapping("/unassigned")
    public List<ResponseUnassignedProductCode> allUnassignedProductCodes() {
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
