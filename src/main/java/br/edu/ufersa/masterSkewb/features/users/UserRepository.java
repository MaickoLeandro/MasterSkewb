package br.edu.ufersa.masterSkewb.features.users;

import br.edu.ufersa.masterSkewb.features.users.dtos.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<UserResponse> findByNameName(String name);
    Optional<UserResponse> findByEmailEmail(String email);
}
