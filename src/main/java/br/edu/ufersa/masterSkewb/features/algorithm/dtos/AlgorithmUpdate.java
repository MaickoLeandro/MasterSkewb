package br.edu.ufersa.masterSkewb.features.algorithm.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public record AlgorithmUpdate(@Positive long userId, @Positive long caseId, Moves moves) {

}
