package br.edu.ufersa.masterSkewb.features.cases;


public interface CaseService {
    void deleteAllByMethodId(long methodId);
}


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