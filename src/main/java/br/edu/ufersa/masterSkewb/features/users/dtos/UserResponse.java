package br.edu.ufersa.masterSkewb.features.users.dtos;

import br.edu.ufersa.masterSkewb.features.valueObjects.Email;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;

public record UserResponse(long id, Name name, Email email) {
}
