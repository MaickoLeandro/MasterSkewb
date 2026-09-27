package br.edu.ufersa.masterSkewb.features.cases.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CaseUpdate(@Valid @NotNull Name name, @Valid StateId stateId, @Positive long methodId) {
}
