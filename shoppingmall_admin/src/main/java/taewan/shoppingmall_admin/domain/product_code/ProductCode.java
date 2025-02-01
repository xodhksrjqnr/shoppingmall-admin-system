package taewan.shoppingmall_admin.domain.product_code;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class ProductCode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parentId;
    private String code;
    private String name;
    private Character groupIndex;
    private Character assigned;
    @CreatedDate
    private LocalDateTime createDate;

    public static ProductCode create(int parentId, String code, String name, Character groupIndex) {
        return ProductCode.builder()
                .parentId(parentId)
                .code(code.toUpperCase())
                .name(name)
                .groupIndex(groupIndex)
                .assigned(groupIndex.equals('E') ? 'n' : 'y')
                .build();
    }

    public void assigned() {
        this.assigned = 'y';
    }

}
