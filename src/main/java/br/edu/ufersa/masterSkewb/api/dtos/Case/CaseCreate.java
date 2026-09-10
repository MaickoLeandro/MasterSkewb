package br.edu.ufersa.masterSkewb.api.dtos.Case;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;
import br.edu.ufersa.masterSkewb.domain.valueObjects.StateId;

public record CaseCreate(Name name, StateId stateId, long methodId) {
}
