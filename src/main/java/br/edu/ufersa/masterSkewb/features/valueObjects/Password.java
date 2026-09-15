package br.edu.ufersa.masterSkewb.features.valueObjects;

public record Password(String password) {
    public Password {
        if(password == null || password.isBlank())
            throw new IllegalArgumentException("Senha inválida");
    }
}
