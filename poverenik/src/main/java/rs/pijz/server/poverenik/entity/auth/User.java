package rs.pijz.server.poverenik.entity.auth;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NaturalId
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String forename;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String homeNumber;
    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false)
    private Boolean validated;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(RegistrationRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.username = request.getUsername();
        this.password = encoder.encode(request.getPassword());
        this.forename = request.getForename();
        this.surname = request.getSurname();
        this.address = request.getAddress();
        this.city = request.getCity();
        this.homeNumber = request.getHomeNumber();
        this.phone = request.getPhone();
        this.enabled = true;
        this.validated = false;
        this.roles = new HashSet<>() {{
            add(new Role(RoleType.ROLE_GRADJANIN));
        }};
    }

    public User(Long id, String username, String password, String forename, String surname, String address, String city, String country, String phone, Boolean enabled, Boolean validated, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.homeNumber = country;
        this.phone = phone;
        this.enabled = enabled;
        this.validated = validated;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String country) {
        this.homeNumber = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
