package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;
import br.edu.ufersa.masterSkewb.domain.valueObjects.StateId;

public record CaseResponse(Name name, StateId stateId, MethodResponse methodResponse) {
}
