package br.com.sigad.domain.model.classifications;

import br.com.sigad.domain.model.user.Role;
import br.com.sigad.domain.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "confidentialities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Confidentiality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "confidentiality_roles",
            joinColumns = @JoinColumn(name = "confidentiality_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> authorizedRoles = new HashSet<>();

    public boolean isAuthorized(User user) {
    	return user.getRoles()
                .stream()
                .anyMatch(authorizedRoles::contains);
    }

    public void addAuthorizedRole(Role role) {
    	authorizedRoles.add(role);
    }

    public void removeAuthorizedRole(Role role) {
    	authorizedRoles.remove(role);
    }

    public static Confidentiality getInstance() {
    	return Confidentiality.builder()
    			.name("ostensivo")
    			.build();
    }
}
