package br.edu.ufersa.masterSkewb.features.auth;

import br.edu.ufersa.masterSkewb.features.valueObjects.Email;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameName(String name);
    List<User> findByName(Name name);
    Optional<User> findByEmailEmail(String email);
    Optional<User> findByEmail(Email email);
}
