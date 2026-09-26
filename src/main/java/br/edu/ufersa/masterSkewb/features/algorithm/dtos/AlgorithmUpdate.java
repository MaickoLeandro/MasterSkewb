package br.edu.ufersa.masterSkewb.features.algorithm.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
import jakarta.validation.Valid;

public record AlgorithmUpdate(long userId, long caseId, @Valid Moves moves) {

}
