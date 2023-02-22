package codegym.danang.demo.repository;

import codegym.danang.demo.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
}
