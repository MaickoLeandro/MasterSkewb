package br.edu.ufersa.masterSkewb.features.auth.dtos;

import br.edu.ufersa.masterSkewb.features.auth.UserRole;
import br.edu.ufersa.masterSkewb.features.valueObjects.Email;
import br.edu.ufersa.masterSkewb.features.valueObjects.Password;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface AuthDTOs {
    record LoginRequestDTO(
            @Valid Email email,
            @Valid Password password ) {}

    record TokenResponseDTO(String token) {}

    record RegisterRequestDTO(
            @Valid Email email,
            @Valid Password password,
            @NotNull(message = "O perfil (role) é obrigatório")
            UserRole role ) {}
}