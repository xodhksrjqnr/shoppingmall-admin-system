package taewan.shoppingmall_admin.layer2_service;

import taewan.shoppingmall_admin.dto.menu.CategoryDto;
import taewan.shoppingmall_admin.dto.menu.RequestMenuAddDto;
import taewan.shoppingmall_admin.dto.menu.RequestMenuModifyDto;
import taewan.shoppingmall_admin.dto.menu.RequestMenuRemoveDto;

public interface MenuService {

    CategoryDto searchAll();
    void add(RequestMenuAddDto dto);
    void modify(RequestMenuModifyDto dto);
    void delete(RequestMenuRemoveDto dto);
}
