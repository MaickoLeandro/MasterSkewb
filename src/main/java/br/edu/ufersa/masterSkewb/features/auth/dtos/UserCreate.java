package br.edu.ufersa.masterSkewb.features.auth.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Email;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.Password;
import jakarta.validation.Valid;

public record UserCreate(@Valid Name name, @Valid Email email, @Valid Password password) { }