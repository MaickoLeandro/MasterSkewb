package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;

public interface CaseService {
    void deleteAllByMethodId(long methodId);
    CaseResponse getCase(long caseId, long methodId);
}
