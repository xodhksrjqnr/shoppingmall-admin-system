package taewan.shoppingmall_admin.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import taewan.shoppingmall_admin.entity.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT m FROM Menu m WHERE m.accessLevel <= :accessLevel ORDER BY m.depth DESC, m.parentMenuId, m.sequence")
    List<Menu> findAll(@Param("accessLevel") int accessLevel);
    void deleteById(int id);

}
