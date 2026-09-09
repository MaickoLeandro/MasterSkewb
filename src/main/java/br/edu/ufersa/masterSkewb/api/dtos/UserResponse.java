package br.edu.ufersa.masterSkewb.api.dtos;

import br.edu.ufersa.masterSkewb.domain.entities.Email;
import br.edu.ufersa.masterSkewb.domain.entities.Name;

public record UserResponse(long id, Name name, Email email) {
}
