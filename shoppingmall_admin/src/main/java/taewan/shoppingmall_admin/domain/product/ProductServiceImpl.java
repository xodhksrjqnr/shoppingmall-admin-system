package taewan.shoppingmall_admin.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.util.Convertor;
import taewan.shoppingmall_admin.util.FileManager;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    @Value("${image.storage.path}")
    private String pathOfSavingImage;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    @Override
    public List<ProductInfoDto> searchAllWithFilter(RequestSearchProductDto dto) {
        return productRepository.findAllByConditions(dto.makeWhere())
                        .stream().map(ProductInfoDto::new)
                        .collect(Collectors.toList());
    }

    @Override
    public void addOne(RequestAddProductDto dto) {
        int productId = productRepository.save(Convertor.toEntity(dto)).getId();

        productImageRepository.saveAll(
                FileManager.saveFiles(dto.getConvertedImages(), dto.getExtensionList(), pathOfSavingImage + "/product")
                        .stream().map(name -> ProductImage.create(name, productId))
                        .toList()
        );
    }

}
