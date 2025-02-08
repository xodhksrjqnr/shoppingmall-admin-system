package taewan.shoppingmall_admin.layer2_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.dto.AllInfoDto;
import taewan.shoppingmall_admin.layer3_repository.jpa.ProductCodeRepository;
import taewan.shoppingmall_admin.dto.product_code.ProductCodeInfoDto;
import taewan.shoppingmall_admin.dto.product_code.RequestAddProductCodeDto;
import taewan.shoppingmall_admin.dto.product_code.ResponseUnassignedProductCode;
import taewan.shoppingmall_admin.base.util.Convertor;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCodeServiceImpl implements ProductCodeService {

    private final ProductCodeRepository productElementRepository;

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
