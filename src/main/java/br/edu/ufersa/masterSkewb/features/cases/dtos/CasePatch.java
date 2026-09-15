package br.edu.ufersa.masterSkewb.features.cases.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;

public record CasePatch(Name name, StateId stateId){
}
