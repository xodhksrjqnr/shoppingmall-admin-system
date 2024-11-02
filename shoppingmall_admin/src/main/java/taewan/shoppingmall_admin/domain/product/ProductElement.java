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
@Table(name = "product_elements")
public class ProductElement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int parentId;
    private String name;
    private Character groupIndex;
    @CreatedDate
    private LocalDateTime createDate;

    public static ProductElement create(int parentId, String name, Character groupIndex) {
        return ProductElement.builder()
                .parentId(parentId)
                .name(name)
                .groupIndex(groupIndex)
                .build();
    }

}
