package rs.pijz.server.sluzbenik.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rs.pijz.server.sluzbenik.model.korisnik.Korisnik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    public Collection<? extends GrantedAuthority> authorities;
    private String id;
    private String username;
    @JsonIgnore
    private String password;
    private String forename;
    private String surname;
    private String city;
    private String address;
    private Boolean enabled;
    private Boolean validated;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(Korisnik korisnik, List<GrantedAuthority> authorities) {
        this.id = korisnik.getId();
        this.username = korisnik.getUsername();
        this.password = korisnik.getPassword();
        this.forename = korisnik.getFizickoLice().getIme();
        this.surname = korisnik.getFizickoLice().getPrezime();
        this.address = korisnik.getFizickoLice().getAdresa().getUlica() + " " + korisnik.getFizickoLice().getAdresa().getBroj();
        this.city = korisnik.getFizickoLice().getAdresa().getGrad();
        this.enabled = true;
        this.validated = true;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Korisnik korisnik) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + korisnik.getTip()));
        return new UserDetailsImpl(korisnik, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled & validated;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled & validated;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled & validated;
    }

    @Override
    public boolean isEnabled() {
        return enabled & validated;
    }
}
