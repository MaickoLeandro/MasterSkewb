package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseCreate;
import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseUpdate;
import br.edu.ufersa.masterSkewb.features.method.MethodService;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class CaseApplicationService {
    private final CaseRepository caseRepository;
    private final MethodService methodService;

    CaseApplicationService(CaseRepository caseRepository, MethodService methodService) {
        this.caseRepository = caseRepository;
        this.methodService = methodService;
    }

    public List<CaseResponse> getCasesByMethodId(long methodId) {
        MethodResponse methodResponse = methodService.getMethodById(methodId);

        List<CaseResponse> responses = new ArrayList<>();
        for (Case aCase : caseRepository.findByMethodId(methodId)) {
            responses.add(toResponse(aCase, methodResponse));
        }
        return responses;
    }

    public CaseResponse getCaseByMethodIdAndId(long methodId, long caseId) {
        MethodResponse methodResponse = methodService.getMethodById(methodId);
        Case aCase = caseRepository.findById(caseId).orElseThrow();

        return toResponse(aCase, methodResponse);

    }

    @Transactional
    public CaseResponse createCase(long methodId, CaseCreate caseCreate) {
        MethodResponse methodResponse = methodService.getMethodById(methodId);
        Case aCase = caseRepository.save(new Case(null, caseCreate.name(), caseCreate.stateId(), methodId));

        return toResponse(aCase, methodResponse);
    }

    @Transactional
    public CaseResponse updateCase(long methodId, long caseId, CaseUpdate caseUpdate) {
        findCaseByIdAndMethodId(methodId, caseId);
        MethodResponse methodResponse = methodService.getMethodById(caseUpdate.methodId());
        Case aCase = caseRepository.save(new Case(caseId, caseUpdate.name(), caseUpdate.stateId(), caseUpdate.methodId()));

        return toResponse(aCase, methodResponse);
    }

    @Transactional
    public void deleteCaseByMethodIdAndId(long methodId, long caseId) {
        caseRepository.delete(findCaseByIdAndMethodId(methodId, caseId));
    }

    public CaseResponse getCaseByIdAndMethodId(long methodId, long caseId) {
        Case aCase = findCaseByIdAndMethodId(methodId,  caseId);

        return toResponse(aCase, methodService.getMethodById(methodId));
    }

    private Case findCaseByIdAndMethodId(long methodId, long caseId) {
        return caseRepository.findByIdAndMethodId(caseId, methodId).orElseThrow();
    }

    private CaseResponse toResponse(Case aCase, MethodResponse methodResponse) {
        return new CaseResponse(aCase.getId(), aCase.getName(), aCase.getStateId(), methodResponse);
    }

}
