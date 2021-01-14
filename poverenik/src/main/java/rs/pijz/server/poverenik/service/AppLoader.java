package rs.pijz.server.poverenik.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import rs.pijz.server.poverenik.entity.auth.Role;
import rs.pijz.server.poverenik.entity.auth.RoleType;
import rs.pijz.server.poverenik.entity.auth.User;
import rs.pijz.server.poverenik.repository.auth.UserRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class AppLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    public AppLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findAll().size() == 0 || !hasAdmin()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            Role role = new Role();
            role.setName(RoleType.ROLE_SYSTEMADMIN);
            Set<Role> roles = new HashSet<>();
            roles.add(role);

            User user = new User();
            user.setUsername("pijz.portal.rs@gmail.com");
            user.setPassword(encoder.encode("ybtmjKNDaw5T98d"));
            user.setCity("Everywhere");
            user.setAddress("Amazing Street");
            user.setHomeNumber("8");
            user.setForename("Alpha");
            user.setSurname("Omega");
            user.setPhone("+000 00 000 0000");
            user.setRoles(roles);
            user.setValidated(true);
            user.setEnabled(true);

            userRepository.save(user);
            System.out.println("User added.");

        }
    }

    private Boolean hasAdmin() {
        AtomicReference<Boolean> hasAdmin = new AtomicReference<>(false);
        userRepository.findAll().forEach(user -> {
            user.getRoles().forEach(role -> {
                if (role.getName().equals(RoleType.ROLE_SYSTEMADMIN)) {
                    hasAdmin.set(true);
                }
            });
        });
        return hasAdmin.get();
    }
}