package taewan.shoppingmall_admin.entity;

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
public class ProductImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int productId;
    @CreatedDate
    private LocalDateTime savedDate;

    public static ProductImage create(String name, int productId) {
        return ProductImage.builder()
                .name(name)
                .productId(productId)
                .build();
    }
}
