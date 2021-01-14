package rs.pijz.server.sluzbenik.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.pijz.server.sluzbenik.entity.auth.Role;
import rs.pijz.server.sluzbenik.entity.auth.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);
}
