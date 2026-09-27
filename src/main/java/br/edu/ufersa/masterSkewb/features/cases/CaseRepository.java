package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface CaseRepository extends CrudRepository<Case, Long> {
    List<Case> findByMethodId(long methodId);
    Optional<Case> findByIdAndMethodId(long id, long methodId);
    List<Case> findByStateId(StateId stateId);
    void deleteAllByMethodId(Long methodId);
}
