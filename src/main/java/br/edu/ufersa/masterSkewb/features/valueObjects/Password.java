package br.edu.ufersa.masterSkewb.features.valueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Password(String password) {
    public Password {
        if(password == null || password.isBlank())
            throw new IllegalArgumentException("Senha inválida");
    }
}
