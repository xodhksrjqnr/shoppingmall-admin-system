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
public class ProductCodeServiceImpl implements ProductCodeService {

    private final ProductCodeRepository productElementRepository;

    public Map<Character, List<ProductCodeInfoDto>> searchAll() {
        Map<Character, List<ProductCodeInfoDto>> productElementList = new LinkedHashMap<>(Map.of(
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
    public List<ProductCodeInfoDto> searchOneGroup(int parentId) {
        List<ProductCodeInfoDto> productElementInfoDtos = new LinkedList<>();

        productElementRepository.findAllByParentId(parentId)
                .forEach(productElement ->
                        productElementInfoDtos.add(Convertor.toProductElementInfoDto(productElement))
                );
        return productElementInfoDtos;
    }

    @Override
    public void addOne(RequestAddProductCodeDto dto) {
        productElementRepository.save(Convertor.toEntity(dto));
    }

}
