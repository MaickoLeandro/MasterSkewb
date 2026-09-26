package br.edu.ufersa.masterSkewb.features.algorithm.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
import jakarta.validation.Valid;

public record AlgorithmPatch(long userId, long caseId, @Valid Moves moves) {
}
