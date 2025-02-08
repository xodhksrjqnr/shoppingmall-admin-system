package taewan.shoppingmall_admin.layer3_repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.shoppingmall_admin.base.entity.Administrator;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    Optional<Administrator> findByUserId(String userId);
}
