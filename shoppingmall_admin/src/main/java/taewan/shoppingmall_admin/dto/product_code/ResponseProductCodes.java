package taewan.shoppingmall_admin.dto.product_code;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseProductCodes {

    private List<ProductCodeDto> groupList;

    public ResponseProductCodes(List<ProductCodeDto> groupList) {
        this.groupList = groupList;
    }
}
