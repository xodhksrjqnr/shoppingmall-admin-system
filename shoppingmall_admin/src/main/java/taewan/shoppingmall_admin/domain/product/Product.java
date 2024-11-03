package taewan.shoppingmall_admin.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nameEng;
    private String code;
    private Integer sellingPrice;
    private Integer costPrice;
    private Integer stock;
    private String brand;
    private String placeOfOrigin;
    @CreatedDate
    private LocalDateTime createdDate;

    public static Product create(String name, String nameEng, String code, Integer sellingPrice, Integer costPrice, Integer stock, String brand, String placeOfOrigin) {
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
