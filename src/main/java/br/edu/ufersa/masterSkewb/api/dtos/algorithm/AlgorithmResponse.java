package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.api.dtos.Case.CaseResponse;

public record AlgorithmResponse(long id, UserResponse userResponse, CaseResponse caseResponse) {
}
