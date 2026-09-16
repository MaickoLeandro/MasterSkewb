package br.edu.ufersa.masterSkewb.features.valueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Name(String name) {
    public Name{
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Nome inválido");
    }
}
