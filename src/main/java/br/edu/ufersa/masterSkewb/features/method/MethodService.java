package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MethodService {
    MethodResponse getMethodById(long methodId);
}

@Service
class MethodServiceImpl implements MethodService {
    private final MethodApplicationService methodApplicationService;

    public MethodServiceImpl(MethodApplicationService methodApplicationService) {
        this.methodApplicationService = methodApplicationService;
    }

    @Override
    public MethodResponse getMethodById(long methodId) {
        return methodApplicationService.getMethodById(methodId);
    }

}
