package br.edu.ufersa.masterSkewb.api.dtos.algorithm;

import br.edu.ufersa.masterSkewb.api.dtos.cases.CaseResponse;
import br.edu.ufersa.masterSkewb.api.dtos.users.UserResponse;

public record AlgorithmUpdate(UserResponse userResponse, CaseResponse caseResponse) {

}
