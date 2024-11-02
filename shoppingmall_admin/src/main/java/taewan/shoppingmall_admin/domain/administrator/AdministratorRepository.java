package taewan.shoppingmall_admin.domain.administrator;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    Optional<Administrator> findByUserId(String userId);
}
