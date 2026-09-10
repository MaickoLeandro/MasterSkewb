package br.edu.ufersa.masterSkewb.api.controllers;

import br.edu.ufersa.masterSkewb.api.dtos.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/metodos/{methodId}/casos/{caseId}/algoritmos")
public class AlgorithmController {
    @GetMapping
    public ResponseEntity<List<AlgorithmResponse>> list(
            @PathVariable long methodId,
            @PathVariable long caseId) {
        return null;
    }

    @GetMapping("/{algorithmId}")
    public ResponseEntity<AlgorithmResponse> findById(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @PathVariable long algorithmId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<AlgorithmResponse> create(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @RequestBody AlgorithmCreate dto) {
        return null;
    }

    @PutMapping("/{algorithmId}")
    public ResponseEntity<AlgorithmResponse> update(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @PathVariable long algorithmId,
            @RequestBody AlgorithmUpdate dto) {
        return null;
    }

    @PatchMapping("/{algorithmId}")
    public ResponseEntity<AlgorithmResponse> patch(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @PathVariable long algorithmId,
            @RequestBody AlgorithmPatch dto) {
        return null;
    }

    @DeleteMapping("/{algorithmId}")
    public ResponseEntity<Void> delete(
            @PathVariable long methodId,
            @PathVariable long caseId,
            @PathVariable long algorithmId) {
        return null;
    }
}