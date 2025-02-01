package taewan.shoppingmall_admin.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Base64;
import java.util.List;

@Getter
@AllArgsConstructor
public class RequestAddProductDto {

    private String name;
    private String nameEng;
    private String code;
    private Integer codeId;
    private String sellingPrice;
    private String costPrice;
    private Integer stock;
    private String brand;
    private String placeOfOrigin;
    private List<String> base64ImageList;
    private List<String> extensionList;

    public List<byte[]> getConvertedImages() {
        return this.base64ImageList.stream().map(img -> Base64.getDecoder().decode(img)).toList();
    }
}
