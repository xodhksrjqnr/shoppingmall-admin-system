package taewan.shoppingmall_admin.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.domain.product.dto.ProductInfoDto;
import taewan.shoppingmall_admin.domain.product.dto.RequestAddProductDto;
import taewan.shoppingmall_admin.domain.product.dto.RequestSearchProductDto;
import taewan.shoppingmall_admin.domain.product_code.ProductCodeRepository;
import taewan.shoppingmall_admin.util.Convertor;
import taewan.shoppingmall_admin.util.FileManager;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    @Value("${image.storage.path}")
    private String pathOfSavingImage;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductCodeRepository productCodeRepository;

    @Override
    public List<ProductInfoDto> searchAllWithFilter(RequestSearchProductDto dto) {
        return productRepository.findAllByConditions(dto.makeWhere())
                        .stream().map(ProductInfoDto::new)
                        .collect(Collectors.toList());
    }

    @Override
    public void addOne(RequestAddProductDto dto) {
        int productId = productRepository.save(Convertor.toEntity(dto)).getId();

        productCodeRepository.findByIdAndAssigned(dto.getCodeId(), 'n')
                .orElseThrow(() -> new NoSuchElementException("이미 사용되었거나 존재하지 않는 코드입니다."))
                        .assigned();

        productImageRepository.saveAll(
                FileManager.saveFiles(dto.getConvertedImages(), dto.getExtensionList(), pathOfSavingImage + "/product")
                        .stream().map(name -> ProductImage.create(name, productId))
                        .toList()
        );


    }

}
