package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.cases.CaseService;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodCreate;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodUpdate;
import br.edu.ufersa.masterSkewb.features.shared.exception.EntidadeNaoEncontradaException;
import br.edu.ufersa.masterSkewb.features.shared.exception.OperacaoInvalidaException;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class MethodApplicationService {
    private final MethodRepository methodRepository;
    private final CaseService caseService;

    public MethodApplicationService(MethodRepository methodRepository, CaseService caseService) {
        this.methodRepository = methodRepository;
        this.caseService = caseService;
    }

    public MethodResponse getMethodById(long methodId) {
        Method method = methodRepository.findById(methodId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Método não encontrado")
        );

        return new MethodResponse(method.getId(), method.getName().name());
    }

    public List<MethodResponse> getMethods() {
        List<MethodResponse> methodResponseList = new ArrayList<>();
        for (Method method : methodRepository.findAll()) {
            methodResponseList.add(new MethodResponse(method.getId(), method.getName().name()));
        }

        return methodResponseList;
    }
    @Transactional
    public MethodResponse createMethod(MethodCreate methodCreate) {
        if (methodRepository.existsByNameName(methodCreate.name())){
            throw new OperacaoInvalidaException("Método Já Existente");
        }

        Method method = methodRepository.save(new Method(null, new  Name(methodCreate.name())));

        return new MethodResponse(method.getId(), method.getName().name());
    }

    @Transactional
    public MethodResponse updateMethod(long id, MethodUpdate methodUpdate) {
        if (!methodRepository.existsById(id)){
            throw new EntidadeNaoEncontradaException("Método não encontrado");
        }

        if (methodRepository.existsByNameName(methodUpdate.name())){
            throw new OperacaoInvalidaException("Método Já Existente");
        }

        Method method = methodRepository.save(new Method(id, new Name(methodUpdate.name())));

        return new MethodResponse(method.getId(), method.getName().name());
    }

    @Transactional
    public void deleteMethodById(long methodId) {
        Method method = methodRepository.findById(methodId).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Método não encontrado")
        );
        methodRepository.delete(method);
        caseService.deleteAllByMethodId(methodId);
        new MethodResponse(method.getId(), method.getName().name());
    }
}
