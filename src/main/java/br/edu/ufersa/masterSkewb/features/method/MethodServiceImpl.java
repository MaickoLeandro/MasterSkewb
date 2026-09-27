package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import org.springframework.stereotype.Service;

@Service
class MethodServiceImpl implements MethodService {
    MethodRepository methodRepository;
    public MethodServiceImpl(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    @Override
    public MethodResponse getMethodById(long methodId) {
        Method method = methodRepository.findById(methodId).orElseThrow();

        return  new MethodResponse(methodId, method.getName().name());
    }

}
