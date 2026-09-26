package br.edu.ufersa.masterSkewb.features.algorithm.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
import jakarta.validation.Valid;

public record AlgorithmCreate(long userId, long caseId, @Valid Moves moves) {
}
