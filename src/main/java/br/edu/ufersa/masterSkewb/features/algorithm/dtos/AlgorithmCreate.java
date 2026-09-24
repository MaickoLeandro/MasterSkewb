package br.edu.ufersa.masterSkewb.features.algorithm.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;

public record AlgorithmCreate(long userId, long caseId, Moves moves) {
}
