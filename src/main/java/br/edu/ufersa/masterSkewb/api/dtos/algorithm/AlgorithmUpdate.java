package br.edu.ufersa.masterSkewb.api.dtos.algorithm;

import br.edu.ufersa.masterSkewb.api.dtos.Case.CaseResponse;
import br.edu.ufersa.masterSkewb.api.dtos.User.UserResponse;

public record AlgorithmUpdate(UserResponse userResponse, CaseResponse caseResponse) {

}
