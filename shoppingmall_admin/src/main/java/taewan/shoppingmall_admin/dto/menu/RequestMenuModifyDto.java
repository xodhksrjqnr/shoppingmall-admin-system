package taewan.shoppingmall_admin.dto.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMenuModifyDto {

    private int id;
    private String name;
    private String link;
    private int accessLevel;
    private int sequence;

}
