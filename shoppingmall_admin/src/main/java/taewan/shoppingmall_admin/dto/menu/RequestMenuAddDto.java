package taewan.shoppingmall_admin.dto.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMenuAddDto {

    private int parentMenuId;
    private String name;
    private String depth;
    private String link;
    private int accessLevel;
    private int sequence;

}
