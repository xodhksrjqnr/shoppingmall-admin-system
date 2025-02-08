package taewan.shoppingmall_admin.layer2_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taewan.shoppingmall_admin.base.util.Convertor;
import taewan.shoppingmall_admin.dto.AllInfoDto;
import taewan.shoppingmall_admin.dto.brand.BrandInfoDto;
import taewan.shoppingmall_admin.dto.product.ProductInfoDto;
import taewan.shoppingmall_admin.layer3_repository.jpa.*;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasicServiceImpl implements BasicService {

    private final BrandRepository brandRepository;
    private final ProductCodeRepository productCodeRepository;
    private final ProductRepository productRepository;

    public List<AllInfoDto> searchAll(String repositoryName) {
        switch (repositoryName) {
            case "brand" -> { return brandRepository.findAll().stream().map(BrandInfoDto::new).collect(Collectors.toList()); }
            case "product" -> { return productRepository.findAll().stream().map(ProductInfoDto::new).collect(Collectors.toList()); }
            case "productCode" -> { return productCodeRepository.findAll().stream().map(Convertor::toProductCodeInfoDto).collect(Collectors.toList()); }
            default -> throw new InvalidParameterException("등록되지 않은 레포지토리입니다.");
        }
    }

}
