package br.edu.ufersa.masterSkewb.features.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Password(
        @NotBlank(message = "A senha é obrigatória")
        String password) {
}
