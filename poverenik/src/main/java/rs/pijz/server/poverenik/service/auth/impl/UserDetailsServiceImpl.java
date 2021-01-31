package rs.pijz.server.poverenik.service.auth.impl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.pijz.server.poverenik.entity.auth.UserDetailsImpl;
import rs.pijz.server.poverenik.model.korisnik.Korisnik;
import rs.pijz.server.poverenik.repository.auth.UserRepository;
import rs.pijz.server.poverenik.service.KorisnikService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private KorisnikService korisnikService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikService.getByUsername(username);
        return UserDetailsImpl.build(korisnik);
    }
}
