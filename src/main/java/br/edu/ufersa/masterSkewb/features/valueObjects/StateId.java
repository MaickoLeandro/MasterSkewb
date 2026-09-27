package br.edu.ufersa.masterSkewb.features.valueObjects;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Embeddable
public record StateId(@NotNull @Positive Long stateId) {
}
