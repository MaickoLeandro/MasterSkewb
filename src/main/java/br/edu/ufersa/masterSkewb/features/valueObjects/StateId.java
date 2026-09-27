package br.edu.ufersa.masterSkewb.features.valueObjects;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public record StateId(@NotNull Long stateId) {
}
