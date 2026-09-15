package br.edu.ufersa.masterSkewb.api.dtos.users;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Email;
import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;
import br.edu.ufersa.masterSkewb.domain.valueObjects.Password;

public record UserPatch(Name name, Email email, Password password) {
}
