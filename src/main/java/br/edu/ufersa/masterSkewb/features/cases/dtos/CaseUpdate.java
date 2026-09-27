package br.edu.ufersa.masterSkewb.features.cases.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public record CaseUpdate(Name name, @Positive StateId stateId, @Positive long methodId) {
}
