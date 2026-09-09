package br.edu.ufersa.masterSkewb.domain.valueObjects;

public record Name(String name) {
    public Name{
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Nome inválido");
    }
}
