package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import org.springframework.stereotype.Service;

@Service
class CaseServiceImpl implements CaseService {
    CaseRepository caseRepository;
    CaseApplicationService caseService;
    public CaseServiceImpl(CaseRepository caseRepository, CaseApplicationService caseService) {
        this.caseRepository = caseRepository;
        this.caseService = caseService;
    }

    @Override
    public void deleteAllByMethodId(long methodId){
        caseRepository.deleteAllByMethodId(methodId);
    }

    @Override
    public CaseResponse getCase(long caseId, long methodId) {
        return caseService.getCaseByIdAndMethodId(caseId, methodId);
    }
}
