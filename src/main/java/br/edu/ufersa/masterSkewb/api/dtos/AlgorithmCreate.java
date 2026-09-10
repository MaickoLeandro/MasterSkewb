package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.api.dtos.Case.CaseResponse;

public record AlgorithmCreate(UserResponse userResponse, CaseResponse caseResponse) {
}
