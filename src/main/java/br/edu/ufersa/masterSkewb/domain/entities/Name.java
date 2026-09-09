package br.edu.ufersa.masterSkewb.domain.entities;

public record Name(String name) {
    public Name{
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Nome inválido");
    }
}
