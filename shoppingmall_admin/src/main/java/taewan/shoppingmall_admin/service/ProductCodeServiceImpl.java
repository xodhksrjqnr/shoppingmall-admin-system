package taewan.shoppingmall_admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.repository.product_code.ProductCodeRepository;
import taewan.shoppingmall_admin.dto.product_code.ProductCodeInfoDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;
import taewan.shoppingmall_admin.util.Convertor;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCodeServiceImpl implements ProductCodeService {

    private final ProductCodeRepository productElementRepository;

    @Override
    public List<ProductCodeInfoDto> searchAll() {
        return productElementRepository.findAll()
                .stream().map(Convertor::toProductCodeInfoDto)
                .toList();
    }

    public List<ResponseUnassignedProductCode> searchUnassignedAll() {
        return productElementRepository.findUnassignedProductCodes();
    }

    @Override
    public List<ProductCodeInfoDto> searchOneGroup(int parentId) {
        return productElementRepository.findAllByParentId(parentId)
                .stream().map(Convertor::toProductCodeInfoDto)
                .toList();
    }

    @Override
    public void addOne(RequestAddProductCodeDto dto) {
        productElementRepository.save(Convertor.toEntity(dto));
    }

}
