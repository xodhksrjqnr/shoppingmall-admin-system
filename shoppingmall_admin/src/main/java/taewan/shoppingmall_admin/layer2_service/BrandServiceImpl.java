package taewan.shoppingmall_admin.layer2_service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.dto.brand.BrandInfoDto;
import taewan.shoppingmall_admin.dto.brand.RequestAddBrandDto;
import taewan.shoppingmall_admin.layer3_repository.jpa.BrandRepository;
import taewan.shoppingmall_admin.base.util.Convertor;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<BrandInfoDto> searchAll() {
        return brandRepository.findAll().stream().map(BrandInfoDto::new).toList();
    }

    @Override
    public void addOne(RequestAddBrandDto dto) {
        if (brandRepository.existsByCode(dto.getCode())) {
            throw new DuplicateKeyException("이미 존재하는 코드입니다.");
        }
        brandRepository.save(Convertor.toEntity(dto));
    }
}
