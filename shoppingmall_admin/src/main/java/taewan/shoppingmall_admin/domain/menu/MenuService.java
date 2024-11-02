package taewan.shoppingmall_admin.domain.menu;

public interface MenuService {

    CategoryDto searchAll();
    void add(RequestMenuAddDto dto);
    void modify(RequestMenuModifyDto dto);
    void delete(RequestMenuRemoveDto dto);
}
