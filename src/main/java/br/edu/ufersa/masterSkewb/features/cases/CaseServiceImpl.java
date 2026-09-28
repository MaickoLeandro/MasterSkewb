package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import br.edu.ufersa.masterSkewb.features.method.MethodService;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import br.edu.ufersa.masterSkewb.features.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
class CaseServiceImpl implements CaseService {
    CaseRepository caseRepository;
    MethodService methodService;

    public CaseServiceImpl(CaseRepository caseRepository, MethodService methodService) {
        this.caseRepository = caseRepository;
        this.methodService = methodService;
    }

    @Override
    public void deleteAllByMethodId(long methodId){
        caseRepository.deleteAllByMethodId(methodId);
    }

    @Override
    public CaseResponse getCase(long caseId, long methodId) {
        Case aCase = caseRepository.findByIdAndMethodId(caseId, methodId).orElseThrow(
                () -> new ResourceNotFoundException("Caso não encontrado")
        );
        MethodResponse methodResponse = methodService.getMethodById(methodId);

        return new CaseResponse(aCase.getId(), aCase.getName(), aCase.getStateId(), methodResponse);
    }
}
