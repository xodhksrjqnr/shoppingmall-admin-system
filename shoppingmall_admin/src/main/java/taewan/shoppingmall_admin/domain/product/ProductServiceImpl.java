package taewan.shoppingmall_admin.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.util.Convertor;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductElementRepository productElementRepository;

    public Map<Character, List<ProductElementInfoDto>> searchAll() {
        Map<Character, List<ProductElementInfoDto>> productElementList = new LinkedHashMap<>(Map.of(
                'E', new LinkedList<>(),
                'D', new LinkedList<>(),
                'C', new LinkedList<>(),
                'B', new LinkedList<>(),
                'A', new LinkedList<>()
        ));


        productElementRepository.findAll()
                .forEach(productElement -> {
                    productElementList.get(productElement.getGroupIndex())
                            .add(Convertor.toProductElementInfoDto(productElement));
                });

        return productElementList;
    }

    @Override
    public List<ProductElementInfoDto> searchOneGroup(int parentId) {
        List<ProductElementInfoDto> productElementInfoDtos = new LinkedList<>();

        productElementRepository.findAllByParentId(parentId)
                .forEach(productElement ->
                        productElementInfoDtos.add(Convertor.toProductElementInfoDto(productElement))
                );
        return productElementInfoDtos;
    }

    @Override
    public void addOne(RequestAddProductElementDto dto) {
        productElementRepository.save(Convertor.toEntity(dto));
    }

}
