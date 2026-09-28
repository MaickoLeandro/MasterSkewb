package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseCreate;
import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseResponse;
import br.edu.ufersa.masterSkewb.features.cases.dtos.CaseUpdate;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/metodos/{methodId}/casos")
@Validated
public class CaseController {
    private final CaseApplicationService caseApplicationService;

    public CaseController(CaseApplicationService caseApplicationService) {
        this.caseApplicationService = caseApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<CaseResponse>> list(@PathVariable long methodId) {
        return ResponseEntity.ok(caseApplicationService.getCasesByMethodId(methodId));
    }


    @GetMapping("/{caseId}")
    public ResponseEntity<CaseResponse> get(@PathVariable long methodId, @PathVariable long caseId) {
        return ResponseEntity.ok(caseApplicationService.getCaseByMethodIdAndId(methodId, caseId));
    }


    @PostMapping
    public ResponseEntity<CaseResponse> post(@PathVariable long methodId,
                                             @RequestBody @Valid CaseCreate dto,
                                             UriComponentsBuilder uriBuilder) {
        CaseResponse salvo = caseApplicationService.createCase(methodId,dto);
        URI uri = uriBuilder
                .path("/api/v1/metodos/{methodId}/casos/{caseId}")
                .buildAndExpand(methodId,salvo.id())
                .toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @PutMapping("/{caseId}")
    public ResponseEntity<CaseResponse> put(@PathVariable long methodId,
                                            @PathVariable long caseId,
                                            @RequestBody @Valid CaseUpdate dto) {
        return ResponseEntity.ok(caseApplicationService.updateCase(methodId, caseId, dto));
    }

    @DeleteMapping("/{caseId}")
    public ResponseEntity<Void> delete(@PathVariable long methodId, @PathVariable long caseId) {
        caseApplicationService.deleteCaseByMethodIdAndId(methodId, caseId);
        return ResponseEntity.ok().build();
    }
}
