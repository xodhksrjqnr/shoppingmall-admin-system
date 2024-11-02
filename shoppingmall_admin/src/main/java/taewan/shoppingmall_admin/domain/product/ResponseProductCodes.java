package taewan.shoppingmall_admin.domain.product;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ResponseProductCodes {

    private Map<Character, List<ProductCodeInfoDto>> groupList;

    public ResponseProductCodes(Map<Character, List<ProductCodeInfoDto>> groupList) {
        this.groupList = groupList;
    }

    public ResponseProductCodes(List<ProductCodeInfoDto> theGroup) {
        if (theGroup.isEmpty()) {
            groupList = new HashMap<>();
            return;
        }

        this.groupList = new HashMap<>(Map.of(
                (char)(theGroup.get(0).getGroupIndex()), theGroup
        ));
    }
}
