package taewan.shoppingmall_admin.domain.brand;

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
public class Brand {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;
    @CreatedDate
    private LocalDateTime createdDate;

    public static Brand create(String name, String code) {
        return Brand.builder()
                .name(name)
                .code(code)
                .build();
    }

}
