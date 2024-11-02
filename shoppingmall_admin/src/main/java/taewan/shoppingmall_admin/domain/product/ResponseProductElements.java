package taewan.shoppingmall_admin.domain.product;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ResponseProductElements {

    private Map<Character, List<ProductElementInfoDto>> groupList;

    public ResponseProductElements(Map<Character, List<ProductElementInfoDto>> groupList) {
        this.groupList = groupList;
    }

    public ResponseProductElements(List<ProductElementInfoDto> theGroup) {
        if (theGroup.isEmpty()) {
            groupList = new HashMap<>();
            return;
        }

        this.groupList = new HashMap<>(Map.of(
                (char)(theGroup.get(0).getGroupIndex()), theGroup
        ));
    }
}
