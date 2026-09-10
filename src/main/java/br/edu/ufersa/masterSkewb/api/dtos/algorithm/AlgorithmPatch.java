package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.api.dtos.Case.CaseResponse;

public record AlgorithmPatch(UserResponse userResponse, CaseResponse caseResponse) {
}
