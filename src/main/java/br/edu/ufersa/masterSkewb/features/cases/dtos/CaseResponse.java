package br.edu.ufersa.masterSkewb.features.cases.dtos;

import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;

public record CaseResponse(Name name, StateId stateId, MethodResponse methodResponse) {
}
