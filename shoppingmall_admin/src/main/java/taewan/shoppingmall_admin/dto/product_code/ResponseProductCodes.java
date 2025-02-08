package taewan.shoppingmall_admin.dto.product_code;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseProductCodes {

    private List<ProductCodeInfoDto> groupList;

    public ResponseProductCodes(List<ProductCodeInfoDto> groupList) {
        this.groupList = groupList;
    }
}
