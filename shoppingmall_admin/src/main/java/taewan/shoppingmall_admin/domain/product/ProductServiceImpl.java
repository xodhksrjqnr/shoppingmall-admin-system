package taewan.shoppingmall_admin.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.util.Convertor;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductInfoDto> searchAllWithFilter() {
        List<ProductInfoDto> dtos = new LinkedList<>();

        productRepository.findAllByConditions()
                .forEach(product -> dtos.add(new ProductInfoDto(product)));

        return dtos;
    }

    @Override
    public void addOne(RequestAddProductDto dto) {
        productRepository.save(Convertor.toEntity(dto));
    }

}
