package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;

public interface MethodService {
    MethodResponse getMethodById(long methodId);
}