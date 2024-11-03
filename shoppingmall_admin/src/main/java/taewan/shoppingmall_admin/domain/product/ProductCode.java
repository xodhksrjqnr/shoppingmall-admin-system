package taewan.shoppingmall_admin.domain.product;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class ProductCode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parentId;
    private String name;
    private Character groupIndex;
    @CreatedDate
    private LocalDateTime createDate;

    public static ProductCode create(int parentId, String name, Character groupIndex) {
        return ProductCode.builder()
                .parentId(parentId)
                .name(name)
                .groupIndex(groupIndex)
                .build();
    }

}
