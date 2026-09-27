package br.edu.ufersa.masterSkewb.features.algorithm.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public record AlgorithmCreate(@Positive long userId, @Positive long caseId, @Valid Moves moves) {
}
