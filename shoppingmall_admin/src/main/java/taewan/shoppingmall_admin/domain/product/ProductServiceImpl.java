package taewan.shoppingmall_admin.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<ProductInfoDto> searchAllWithFilter() {
        productRepository.findAllByConditions();
        return null;
    }

}
