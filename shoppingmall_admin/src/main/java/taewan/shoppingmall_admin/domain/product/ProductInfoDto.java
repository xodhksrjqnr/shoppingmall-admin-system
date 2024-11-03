package taewan.shoppingmall_admin.domain.product;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductInfoDto {

    private final int id;
    private final String name;
    private final String nameEng;
    private final String code;
    private final Integer sellingPrice;
    private final Integer costPrice;
    private final Integer stock;
    private final String brand;
    private final String placeOfOrigin;
    private final LocalDateTime createdDate;

    public ProductInfoDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.nameEng = entity.getNameEng();
        this.code = entity.getCode();
        this.sellingPrice = entity.getSellingPrice();
        this.costPrice = entity.getCostPrice();
        this.stock = entity.getStock();
        this.brand = entity.getBrand();
        this.placeOfOrigin = entity.getPlaceOfOrigin();
        this.createdDate = entity.getCreatedDate();
    }
}
