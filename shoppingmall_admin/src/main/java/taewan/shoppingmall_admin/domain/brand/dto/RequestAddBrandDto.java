package taewan.shoppingmall_admin.domain.brand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestAddBrandDto {

    private String name;
    private String code;

}
