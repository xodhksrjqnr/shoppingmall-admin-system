package taewan.shoppingmall_admin.repository.administrator;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.entity.Administrator;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    Optional<Administrator> findByUserId(String userId);
}
