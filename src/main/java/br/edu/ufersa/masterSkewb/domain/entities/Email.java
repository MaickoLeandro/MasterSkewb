package br.edu.ufersa.masterSkewb.domain.entities;

public record Email(String email) {
    public Email{
        if(email == null || !email.contains("@"))
            throw new IllegalArgumentException("O endereço de e-mail é inválido");
    }
}
