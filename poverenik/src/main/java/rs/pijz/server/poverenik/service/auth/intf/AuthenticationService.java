package rs.pijz.server.poverenik.service.auth.intf;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rs.pijz.server.poverenik.entity.auth.User;

import java.util.Collection;

public interface AuthenticationService {
    Authentication getAuthentication();

    String getUsername();

    User getUser();

    UserDetails getUserDetails();

    Collection<? extends GrantedAuthority> getAuthorities();
}
