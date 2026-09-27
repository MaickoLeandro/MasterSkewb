package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.method.dtos.MethodCreate;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodUpdate;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class MethodApplicationService {
    private final MethodRepository methodRepository;

    public MethodApplicationService(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    public MethodResponse getMethodById(long methodId) {
        Method method = methodRepository.findById(methodId).orElseThrow();

        return new MethodResponse(method.getId(), method.getName().name());
    }

    public List<MethodResponse> getMethods() {
        List<MethodResponse> methodResponseList = new ArrayList<>();
        for (Method method : methodRepository.findAll()) {
            methodResponseList.add(new MethodResponse(method.getId(), method.getName().name()));
        }

        return methodResponseList;
    }

    public MethodResponse createMethod(MethodCreate methodCreate) {
        if (methodRepository.existsByNameName(methodCreate.name())){}

        Method method = methodRepository.save(new Method(null, new  Name(methodCreate.name())));

        return new MethodResponse(method.getId(), method.getName().name());
    }

    public MethodResponse updateMethod(long id, MethodUpdate methodPatch) {
        if (!methodRepository.existsById(id)){}

        Method method = methodRepository.save(new Method(id, new Name(methodPatch.name())));

        return new MethodResponse(method.getId(), method.getName().name());
    }

    public  MethodResponse deleteMethodById(long methodId) {
        Method method = methodRepository.findById(methodId).orElseThrow();
        methodRepository.delete(method);
        return new MethodResponse(method.getId(), method.getName().name());
    }
}
