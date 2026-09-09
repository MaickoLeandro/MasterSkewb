package br.edu.ufersa.masterSkewb.api.controllers;

import br.edu.ufersa.masterSkewb.api.dtos.CaseResponse;
import br.edu.ufersa.masterSkewb.api.dtos.CaseUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/metodos/{methodId}")
public class CaseController {
    @GetMapping
    public ResponseEntity<List<CaseResponse>> list(@PathVariable long methodId) {
        return null;
    }


    @GetMapping("/{caseId}")
    public ResponseEntity<CaseResponse> get(@PathVariable long methodId, @PathVariable long caseId) {
        return null;
    }


    @PostMapping
    public ResponseEntity<CaseResponse> post(@PathVariable long methodId, @RequestBody CaseUpdate dto) {
        return null;
    }

    @PutMapping("/{caseId}")
    public ResponseEntity<CaseResponse> put(@PathVariable long methodId,
                                            @PathVariable long caseId,
                                            @RequestBody CaseUpdate dto) {
        return null;
    }

    @PatchMapping("/{caseId}")
    public ResponseEntity<CaseResponse> patch(@PathVariable long methodId,
                                              @PathVariable long caseId,
                                              @RequestBody CaseUpdate dto) {
        return null;
    }

    @DeleteMapping("/{caseId}")
    public ResponseEntity<Void> delete(@PathVariable  long methodId, @PathVariable long caseId) {
        return null;
    }
}
