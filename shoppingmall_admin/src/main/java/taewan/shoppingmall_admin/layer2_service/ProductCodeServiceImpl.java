package taewan.shoppingmall_admin.layer2_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.base.util.convertor.ProductCodeConvertor;
import taewan.shoppingmall_admin.dto.product_code.ProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;
import taewan.shoppingmall_admin.layer3_repository.jpa.ProductCodeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCodeServiceImpl implements ProductCodeService {

    private final ProductCodeRepository productCodeRepository;

    @Override
    public List<ProductCodeDto> searchAll() {
        return productCodeRepository.findAll()
                .stream().map(ProductCodeConvertor::convert).toList();
    }

    public List<ResponseUnassignedProductCode> searchUnassignedAll() {
        return productCodeRepository.findUnassignedProductCodes();
    }

    @Override
    public List<ProductCodeDto> searchOneGroup(int parentId) {
        return productCodeRepository.findAllByParentId(parentId)
                .stream().map(ProductCodeConvertor::convert)
                .toList();
    }

    @Override
    public void addOne(RequestAddProductCodeDto dto) {
        productCodeRepository.save(ProductCodeConvertor.convert(dto));
    }

}
