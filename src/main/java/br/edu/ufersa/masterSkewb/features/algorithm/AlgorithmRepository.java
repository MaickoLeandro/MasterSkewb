package br.edu.ufersa.masterSkewb.features.algorithm;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface AlgorithmRepository extends JpaRepository<Algorithm, Long> {
    List<Algorithm> findByCaseId(long caseId);
    Optional<Algorithm> findByIdAndCaseId(long id, long caseId);
    boolean existsAlgorithmByMoves(Moves moves);
}
