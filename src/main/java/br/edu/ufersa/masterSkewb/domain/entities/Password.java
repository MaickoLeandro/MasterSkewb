package br.edu.ufersa.masterSkewb.domain.entities;

public record Password(String password) {
    public Password {
        if(password == null || password.isBlank())
            throw new IllegalArgumentException("Senha inválida");
    }
}
