package taewan.shoppingmall_admin.layer2_service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.base.entity.ProductImage;
import taewan.shoppingmall_admin.base.util.FileManager;
import taewan.shoppingmall_admin.base.util.convertor.ProductConvertor;
import taewan.shoppingmall_admin.dto.product.ProductDto;
import taewan.shoppingmall_admin.dto.product.ProductInfoWithImageDto;
import taewan.shoppingmall_admin.dto.product.RequestAddProductDto;
import taewan.shoppingmall_admin.dto.product.RequestSearchProductDto;
import taewan.shoppingmall_admin.layer3_repository.jpa.ProductCodeRepository;
import taewan.shoppingmall_admin.layer3_repository.jpa.ProductImageRepository;
import taewan.shoppingmall_admin.layer3_repository.jpa.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

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
    public List<ProductDto> searchAllWithFilter(RequestSearchProductDto dto) {
        return productRepository.findAllByConditions(dto.makeWhere())
                        .stream().map(ProductConvertor::convert).toList();
    }

    @Override
    public ProductInfoWithImageDto searchOne(int productId) {
        return ProductConvertor.convert(
                productRepository.findById(productId)
                        .orElseThrow(() -> new NoSuchElementException("존재하지 않는 상품입니다.")),
                productImageRepository.findAllByProductId(productId)
        );
    }

    @Override
    public void addOne(RequestAddProductDto dto) {
        int productId = productRepository.save(ProductConvertor.convert(dto)).getId();

        productCodeRepository.findByIdAndAssigned(dto.getCodeId(), 'n')
                .orElseThrow(() -> new NoSuchElementException("이미 사용되었거나 존재하지 않는 코드입니다."))
                        .assigned();

        productImageRepository.saveAll(
                FileManager.saveFiles(dto.getConvertedImages(), dto.getExtensionList(), pathOfSavingImage + "product/")
                        .stream().map(name -> ProductImage.create(name, productId))
                        .toList()
        );


    }

}
