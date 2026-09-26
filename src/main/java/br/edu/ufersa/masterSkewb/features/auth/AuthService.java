package br.edu.ufersa.masterSkewb.features.auth;

import br.edu.ufersa.masterSkewb.features.auth.dtos.AuthDTOs;
import br.edu.ufersa.masterSkewb.features.valueObjects.Password;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; }

    public void registrar(AuthDTOs.RegisterRequestDTO dto) {
        if (userRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado no sistema.");
        }
        String encryptedPassword = passwordEncoder.encode(dto.password().password());
        Password password = new Password(encryptedPassword);
        User user = new User(dto.email(), password, dto.role());
        userRepository.save(user);
    }
}
