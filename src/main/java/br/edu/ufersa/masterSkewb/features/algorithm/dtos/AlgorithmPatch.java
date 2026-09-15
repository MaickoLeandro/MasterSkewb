package br.edu.ufersa.masterSkewb.features.algorithm.dtos;

import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import br.edu.ufersa.masterSkewb.features.users.dtos.UserResponse;

public record AlgorithmPatch(UserResponse userResponse, CaseResponse caseResponse) {
}
