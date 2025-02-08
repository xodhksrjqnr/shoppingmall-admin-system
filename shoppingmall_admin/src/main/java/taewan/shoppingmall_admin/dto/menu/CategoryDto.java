package taewan.shoppingmall_admin.dto.menu;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CategoryDto {

    private String name;
    private String link;
    private final List<CategoryDto> subCategory = new LinkedList<>();

    @Builder
    public CategoryDto(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public void addSubCategoryDto(CategoryDto dto) {
        subCategory.add(dto);
    }

}
