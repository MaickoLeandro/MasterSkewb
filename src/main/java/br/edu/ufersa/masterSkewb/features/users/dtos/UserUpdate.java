package br.edu.ufersa.masterSkewb.features.users.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Email;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.Password;

public record UserUpdate(Name name, Email email, Password password) {
}
