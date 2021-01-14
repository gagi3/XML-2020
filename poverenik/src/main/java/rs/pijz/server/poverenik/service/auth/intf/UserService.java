package rs.pijz.server.poverenik.service.auth.intf;

import rs.pijz.server.poverenik.auth.JWTResponse;
import rs.pijz.server.poverenik.entity.auth.LoginRequest;
import rs.pijz.server.poverenik.entity.auth.RegistrationRequest;
import rs.pijz.server.poverenik.entity.auth.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<User> findValidatedAndEnabled();

    User getOne(Long id);

    User findByUsername(String username);

    User create(RegistrationRequest request) throws Exception;

    Boolean confirm(String token) throws Exception;

    JWTResponse login(LoginRequest request);

    User update(User user) throws Exception;

    Boolean delete(Long id);
}
