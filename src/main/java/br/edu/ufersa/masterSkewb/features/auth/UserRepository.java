package br.edu.ufersa.masterSkewb.features.auth;

import br.edu.ufersa.masterSkewb.features.auth.dtos.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    List<UserResponse> findByNameName(String name);
    Optional<User> findByEmailEmail(String email);
}
