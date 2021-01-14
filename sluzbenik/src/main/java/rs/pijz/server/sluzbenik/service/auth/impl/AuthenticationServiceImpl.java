package rs.pijz.server.sluzbenik.service.impl.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rs.pijz.server.sluzbenik.entity.auth.User;
import rs.pijz.server.sluzbenik.entity.auth.UserDetailsImpl;
import rs.pijz.server.sluzbenik.service.intf.auth.AuthenticationService;
import rs.pijz.server.sluzbenik.service.intf.auth.UserService;

import java.util.Collection;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @Override
    public String getUsername() {
        return getAuthentication().getName();
    }
    @Override
    public User getUser() {
        return userService.findByUsername(getUsername());
    }
    @Override
    public UserDetails getUserDetails() {
        return (UserDetailsImpl) getAuthentication().getPrincipal();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getUserDetails().getAuthorities();
    }
}
