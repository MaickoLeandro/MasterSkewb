package br.edu.ufersa.masterSkewb.features.algorithm;

import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmCreate;
import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmResponse;
import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmUpdate;
import br.edu.ufersa.masterSkewb.features.algorithm.exceptions.NotSolvedException;
import br.edu.ufersa.masterSkewb.features.cases.CaseService;
import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import br.edu.ufersa.masterSkewb.features.shared.exception.EntidadeNaoEncontradaException;
import br.edu.ufersa.masterSkewb.features.shared.exception.OperacaoInvalidaException;
import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
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
        Algorithm algorithm = algorithmRepository.findByIdAndCaseId(algorithmId, caseId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Algoritmo não encontrado")
        );
        return toResponse(algorithm);
    }

    @Transactional
    public AlgorithmResponse createAlgorithm(long userId, long methodId, long caseId, AlgorithmCreate create) {
        CaseResponse caseResponse = caseService.getCase(caseId, methodId);

        String finalMoves = algorithmDomainService.validateAlgorithm(create.moves().moves(), caseResponse.stateId().stateId());

        if (finalMoves == null)
            throw new NotSolvedException("O algoritmo não resolve o caso");

        Moves moves = new Moves(finalMoves);

        if (algorithmRepository.existsAlgorithmByMoves(moves)){
            throw new OperacaoInvalidaException("Algoritmo já existente");
        }

        Algorithm algorithm = algorithmRepository.save(
                new Algorithm(null, userId, caseId, moves));
        return toResponse(algorithm);
    }

    @Transactional
    public AlgorithmResponse updateAlgorithm(long userId, long methodId, long caseId, long algorithmId, AlgorithmUpdate update) {
        CaseResponse caseResponse = caseService.getCase(caseId, methodId);
        algorithmRepository.findByIdAndCaseId(algorithmId, caseId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Algoritmo não encontrado")
        );

        String finalMoves = algorithmDomainService.validateAlgorithm(update.moves().moves(), caseResponse.stateId().stateId());

        if (finalMoves == null) {
            throw new NotSolvedException("O algoritmo não resolve o caso");
        }

        Moves moves = new Moves(finalMoves);

        if (algorithmRepository.existsAlgorithmByMoves(moves)){
            throw new OperacaoInvalidaException("Algoritmo já existente");
        }

        Algorithm algorithm = algorithmRepository.save(
                new Algorithm(algorithmId, userId, caseId, moves));
        return toResponse(algorithm);
    }

    @Transactional
    public void deleteAlgorithm(long methodId, long caseId, long algorithmId) {
        caseService.getCase(caseId, methodId);
        Algorithm algorithm = algorithmRepository.findByIdAndCaseId(algorithmId, caseId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Algoritmo não encontrado")
        );
        algorithmRepository.delete(algorithm);
    }

    private AlgorithmResponse toResponse(Algorithm algorithm) {
        return new AlgorithmResponse(algorithm.getId(), algorithm.getUserId(), algorithm.getCaseId(), algorithm.getMoves());
    }
}

