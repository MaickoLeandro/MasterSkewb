package br.edu.ufersa.masterSkewb.features.algorithm;

import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmCreate;
import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmResponse;
import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmUpdate;
import br.edu.ufersa.masterSkewb.features.algorithm.exceptions.NotSolvedException;
import br.edu.ufersa.masterSkewb.features.cases.CaseService;
import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AlgorithmApplicationService {
    private final AlgorithmRepository algorithmRepository;
    private final CaseService caseService;
    private final AlgorithmDomainService algorithmDomainService;

    AlgorithmApplicationService(AlgorithmRepository algorithmRepository, CaseService caseService, AlgorithmDomainService algorithmDomainService) {
        this.algorithmRepository = algorithmRepository;
        this.caseService = caseService;
        this.algorithmDomainService = algorithmDomainService;
    }

    public List<AlgorithmResponse> getAlgorithms(long methodId, long caseId) {
        caseService.getCase(caseId, methodId);
        return algorithmRepository.findByCaseId(caseId).stream().map(this::toResponse).toList();
    }

    public AlgorithmResponse getAlgorithmById(long methodId, long caseId, long algorithmId) {
        caseService.getCase(caseId, methodId);
        Algorithm algorithm = algorithmRepository.findByIdAndCaseId(algorithmId, caseId).orElseThrow();
        return toResponse(algorithm);
    }

    @Transactional
    public AlgorithmResponse createAlgorithm(long methodId, long caseId, AlgorithmCreate create) {
        CaseResponse caseResponse = caseService.getCase(caseId, methodId);

        if (!algorithmDomainService.validateAlgorithm(create.moves().moves(), caseResponse.stateId().stateId()))
            throw new NotSolvedException("O algoritmo não resolve o caso");

        Algorithm algorithm = algorithmRepository.save(
                new Algorithm(null, create.userId(), caseId, create.moves()));
        return toResponse(algorithm);
    }

    @Transactional
    public AlgorithmResponse updateAlgorithm(long methodId, long caseId, long algorithmId, AlgorithmUpdate update) {
        CaseResponse caseResponse = caseService.getCase(caseId, methodId);
        algorithmRepository.findByIdAndCaseId(algorithmId, caseId).orElseThrow();

        if (!algorithmDomainService.validateAlgorithm(update.moves().moves(), caseResponse.stateId().stateId())) {
            throw new NotSolvedException("O algoritmo não resolve o caso");
        }

        Algorithm algorithm = algorithmRepository.save(
                new Algorithm(algorithmId, update.userId(), caseId, update.moves()));
        return toResponse(algorithm);
    }

    @Transactional
    public void deleteAlgorithm(long methodId, long caseId, long algorithmId) {
        caseService.getCase(caseId, methodId);
        Algorithm algorithm = algorithmRepository.findByIdAndCaseId(algorithmId, caseId).orElseThrow();
        algorithmRepository.delete(algorithm);
    }

    private AlgorithmResponse toResponse(Algorithm algorithm) {
        return new AlgorithmResponse(algorithm.getId(), algorithm.getUserId(), algorithm.getCaseId(), algorithm.getMoves());
    }
}

