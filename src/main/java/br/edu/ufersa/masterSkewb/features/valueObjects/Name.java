package br.edu.ufersa.masterSkewb.features.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Name(
        @NotBlank(message = "O nome é obrigatório")
        String name) {
}
