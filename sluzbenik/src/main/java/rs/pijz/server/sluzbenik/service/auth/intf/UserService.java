package rs.pijz.server.sluzbenik.service.intf.auth;

import rs.pijz.server.sluzbenik.auth.JWTResponse;
import rs.pijz.server.sluzbenik.entity.auth.LoginRequest;
import rs.pijz.server.sluzbenik.entity.auth.RegistrationRequest;
import rs.pijz.server.sluzbenik.entity.auth.User;

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
