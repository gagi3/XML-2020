package rs.pijz.server.poverenik.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.pijz.server.poverenik.entity.auth.Role;
import rs.pijz.server.poverenik.entity.auth.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);
}
