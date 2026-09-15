package br.edu.ufersa.masterSkewb.api.dtos.cases;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;
import br.edu.ufersa.masterSkewb.domain.valueObjects.StateId;

public record CasePatch(Name name, StateId stateId){
}
