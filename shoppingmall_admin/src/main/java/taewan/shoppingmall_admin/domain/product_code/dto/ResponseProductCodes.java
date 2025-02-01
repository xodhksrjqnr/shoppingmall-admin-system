package taewan.shoppingmall_admin.domain.product_code.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseProductCodes {

    private List<ProductCodeInfoDto> groupList;

    public ResponseProductCodes(List<ProductCodeInfoDto> groupList) {
        this.groupList = groupList;
    }
}
