package br.edu.ufersa.masterSkewb.api.dtos.users;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Email;
import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;

public record UserResponse(long id, Name name, Email email) {
}
