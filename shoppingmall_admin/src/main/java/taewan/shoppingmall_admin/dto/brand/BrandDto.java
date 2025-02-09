package taewan.shoppingmall_admin.dto.brand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BrandDto {

    private int id;
    private String name;
    private String code;
    private LocalDateTime createdDate;

}
