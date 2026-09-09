package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Email;
import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;
import br.edu.ufersa.masterSkewb.domain.valueObjects.Password;

public record UserCreate(Name name, Email email, Password password) { }