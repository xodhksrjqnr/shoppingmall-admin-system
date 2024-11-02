package taewan.shoppingmall_admin.domain.menu;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Menus")
@DynamicUpdate
@Entity
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parentMenuId;
    private String name;
    private String depth;
    private String link;
    private int accessLevel;
    private int sequence;

    public static Menu create(RequestMenuAddDto dto, int minimumLevel) {
        return Menu.builder()
                .parentMenuId(dto.getParentMenuId())
                .name(dto.getName())
                .depth(dto.getDepth())
                .link(dto.getLink())
                .accessLevel(Math.max(dto.getAccessLevel(), minimumLevel))
                .sequence(dto.getSequence())
                .build();
    }

    public void update(RequestMenuModifyDto dto, int minimumLevel) {
        this.name = dto.getName();
        this.link = dto.getLink();
        this.accessLevel = Math.max(dto.getAccessLevel(), minimumLevel);
        this.sequence = dto.getSequence();
    }
}