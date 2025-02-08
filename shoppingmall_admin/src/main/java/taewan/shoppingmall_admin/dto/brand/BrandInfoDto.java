package taewan.shoppingmall_admin.dto.brand;

import lombok.Getter;
import taewan.shoppingmall_admin.entity.Brand;

import java.time.LocalDateTime;

@Getter
public class BrandInfoDto {

    private int id;
    private String name;
    private String code;
    private LocalDateTime createdDate;

    public BrandInfoDto(Brand entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.code = entity.getCode();
        this.createdDate = entity.getCreatedDate();
    }
}
