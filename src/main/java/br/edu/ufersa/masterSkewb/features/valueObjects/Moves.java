package br.edu.ufersa.masterSkewb.features.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public record Moves(@NotBlank @Size(max = 32) String moves) {
}
