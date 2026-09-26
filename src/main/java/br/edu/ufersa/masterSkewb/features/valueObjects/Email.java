package br.edu.ufersa.masterSkewb.features.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Email(
        @NotBlank(message = "O e-mail é obrigatório")
        @jakarta.validation.constraints.Email(message = "Formato de e-mail inválido")
        String email) {
}