package taewan.shoppingmall_admin.domain.product_code;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.domain.product_code.dto.ProductCodeInfoDto;
import taewan.shoppingmall_admin.domain.product_code.dto.RequestAddProductCodeDto;
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
                .stream().map(Convertor::toProductElementInfoDto)
                .toList();
    }

    public List<String> searchUnassignedAll() {
        return productElementRepository.findUnassignedProductCodes();
    }

    @Override
    public List<ProductCodeInfoDto> searchOneGroup(int parentId) {
        return productElementRepository.findAllByParentId(parentId)
                .stream().map(Convertor::toProductElementInfoDto)
                .toList();
    }

    @Override
    public void addOne(RequestAddProductCodeDto dto) {
        productElementRepository.save(Convertor.toEntity(dto));
    }

}
