package taewan.shoppingmall_admin.domain.product;

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
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nameEng;
    private String code;
    private String sellingPrice;
    private String costPrice;
    private Integer stock;
    private String brand;
    private String placeOfOrigin;
    @CreatedDate
    private LocalDateTime createdDate;

    public static Product create(String name, String nameEng, String code, String sellingPrice, String costPrice, Integer stock, String brand, String placeOfOrigin) {
        return Product.builder()
                .name(name)
                .nameEng(nameEng)
                .code(code)
                .sellingPrice(sellingPrice)
                .costPrice(costPrice)
                .stock(stock)
                .brand(brand)
                .placeOfOrigin(placeOfOrigin)
                .build();
    }

}
