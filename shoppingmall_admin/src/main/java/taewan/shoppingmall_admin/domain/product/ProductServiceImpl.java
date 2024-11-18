package taewan.shoppingmall_admin.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.util.Convertor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductInfoDto> searchAllWithFilter(RequestSearchProductDto dto) {
        return productRepository.findAllByConditions(dto.makeWhere())
                        .stream().map(ProductInfoDto::new)
                        .collect(Collectors.toList());
    }

    @Override
    public void addOne(RequestAddProductDto dto) {
        productRepository.save(Convertor.toEntity(dto));
    }

}
