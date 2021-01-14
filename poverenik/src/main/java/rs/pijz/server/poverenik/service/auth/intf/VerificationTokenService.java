package rs.pijz.server.poverenik.service.auth.intf;

import rs.pijz.server.poverenik.entity.auth.User;
import rs.pijz.server.poverenik.entity.auth.VerificationToken;

import java.util.List;

public interface VerificationTokenService {
    List<VerificationToken> findAll();

    VerificationToken getOne(Long id);

    VerificationToken findByToken(String token);

    VerificationToken create(String username) throws Exception;

    void requestToken(String username) throws Exception;

    VerificationToken findByUser(User user);

    VerificationToken create(User user) throws Exception;

    VerificationToken update(VerificationToken user) throws Exception;

    Boolean delete(Long id);
}
