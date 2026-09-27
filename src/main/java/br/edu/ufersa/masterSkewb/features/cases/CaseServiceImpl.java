package br.edu.ufersa.masterSkewb.features.cases;

import org.springframework.stereotype.Service;

@Service
class CaseServiceImpl implements CaseService {
    CaseRepository caseRepository;
    public CaseServiceImpl(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public void deleteAllByMethodId(long methodId){
        caseRepository.deleteAllByMethodId(methodId);
    }
}
