package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface MethodRepository extends CrudRepository<Method, Long> {
    Optional<MethodResponse> findByNameName(String name);
}
