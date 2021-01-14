package rs.pijz.server.poverenik.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.pijz.server.poverenik.entity.auth.User;
import rs.pijz.server.poverenik.entity.auth.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByUser(User user);

    VerificationToken findByToken(String token);
}
