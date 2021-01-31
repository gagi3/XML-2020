package rs.pijz.server.poverenik.service.auth.impl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rs.pijz.server.poverenik.entity.auth.UserDetailsImpl;
import rs.pijz.server.poverenik.model.korisnik.Korisnik;
import rs.pijz.server.poverenik.service.KorisnikService;
import rs.pijz.server.poverenik.service.auth.intf.AuthenticationService;

import java.util.Collection;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private KorisnikService korisnikService;

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public String getUsername() {
        return getAuthentication().getName();
    }

    @SneakyThrows
    @Override
    public Korisnik getUser() {
        return korisnikService.getByUsername(getUsername());
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
