package taewan.shoppingmall_admin.domain.product_code;

import lombok.Getter;
import taewan.shoppingmall_admin.domain.product_code.ProductCodeInfoDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ResponseProductCodes {

    private List<ProductCodeInfoDto> groupList;

    public ResponseProductCodes(List<ProductCodeInfoDto> groupList) {
        this.groupList = groupList;
    }
}
