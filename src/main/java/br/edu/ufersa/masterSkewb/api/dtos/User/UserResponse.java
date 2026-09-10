package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Email;
import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;

public record UserResponse(long id, Name name, Email email) {
}
