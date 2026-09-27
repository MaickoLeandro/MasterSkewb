package br.edu.ufersa.masterSkewb.features.method.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MethodCreate(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name
) {}
