package br.edu.ufersa.masterSkewb.features.algorithm;

import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlgorithmRepository extends JpaRepository<Algorithm, Long> {
    List<AlgorithmResponse> findByUserId(long id);

    List<AlgorithmResponse> findByCaseId(long id);
}
