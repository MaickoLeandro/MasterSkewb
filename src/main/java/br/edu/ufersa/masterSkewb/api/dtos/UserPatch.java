package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.domain.entities.Email;
import br.edu.ufersa.masterSkewb.domain.entities.Name;
import br.edu.ufersa.masterSkewb.domain.entities.Password;

public record UserPatch(Name name, Email email, Password password) {
}
