package rs.ijz.server.sluzbenik.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.pijz.server.sluzbenik.entity.auth.User;
import rs.pijz.server.sluzbenik.entity.auth.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByUser(User user);

    VerificationToken findByToken(String token);
}
