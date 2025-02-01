package taewan.shoppingmall_admin.domain.menu;

import taewan.shoppingmall_admin.domain.menu.dto.CategoryDto;
import taewan.shoppingmall_admin.domain.menu.dto.RequestMenuAddDto;
import taewan.shoppingmall_admin.domain.menu.dto.RequestMenuModifyDto;
import taewan.shoppingmall_admin.domain.menu.dto.RequestMenuRemoveDto;

public interface MenuService {

    CategoryDto searchAll();
    void add(RequestMenuAddDto dto);
    void modify(RequestMenuModifyDto dto);
    void delete(RequestMenuRemoveDto dto);
}
