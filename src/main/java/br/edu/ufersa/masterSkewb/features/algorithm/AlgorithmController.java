package br.edu.ufersa.masterSkewb.features.algorithm;

import br.edu.ufersa.masterSkewb.features.auth.User;
import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmCreate;
import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmResponse;
import br.edu.ufersa.masterSkewb.features.algorithm.dtos.AlgorithmUpdate;
import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/metodos/{methodId}/casos/{caseId}/algoritmos")
@Validated
public class AlgorithmController {
    private final AlgorithmApplicationService algorithmApplicationService;

    public AlgorithmController(AlgorithmApplicationService algorithmApplicationService) {
        this.algorithmApplicationService = algorithmApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<AlgorithmResponse>> list(
            @PathVariable long methodId,
            @PathVariable long caseId) {
        return ResponseEntity.ok(algorithmApplicationService.getAlgorithms(methodId, caseId));
    }

    @GetMapping("/{algorithmId}")
    public ResponseEntity<AlgorithmResponse> findById(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @PathVariable long algorithmId) {
        return ResponseEntity.ok(algorithmApplicationService.getAlgorithmById(methodId, caseId, algorithmId));
    }

    @PostMapping
    public ResponseEntity<AlgorithmResponse> create(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @RequestBody @Valid AlgorithmCreate dto,
            @AuthenticationPrincipal User user,
            UriComponentsBuilder uriBuilder) {

        AlgorithmResponse salvo = algorithmApplicationService.createAlgorithm(user.getId(), methodId, caseId, dto);
        URI uri = uriBuilder
                .path("/api/v1/metodos/{methodId}/casos/{caseId}/algoritmos/{algorithmId}")
                .buildAndExpand(methodId, caseId, salvo.id())
                .toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @PutMapping("/{algorithmId}")
    public ResponseEntity<AlgorithmResponse> update(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @PathVariable long algorithmId,
            @RequestBody @Valid AlgorithmUpdate dto,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(algorithmApplicationService.updateAlgorithm(user.getId(), methodId, caseId, algorithmId, dto));
    }


    @DeleteMapping("/{algorithmId}")
    public ResponseEntity<Void> delete(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @PathVariable long algorithmId) {
        algorithmApplicationService.deleteAlgorithm(methodId, caseId, algorithmId);
        return ResponseEntity.ok().build();
    }
}
