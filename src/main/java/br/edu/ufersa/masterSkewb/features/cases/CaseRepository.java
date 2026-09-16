package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;
import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CaseRepository extends CrudRepository<Case, Long> {
    Optional<CaseResponse> findByNameName(String name);
    List<CaseResponse> findCasesByMethodId(long methodId);
    List<CaseResponse> findCasesByStateId(StateId stateId);
}
