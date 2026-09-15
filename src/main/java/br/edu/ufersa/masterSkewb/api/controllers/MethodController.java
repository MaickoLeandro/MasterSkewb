package br.edu.ufersa.masterSkewb.api.controllers;

import br.edu.ufersa.masterSkewb.api.dtos.methods.MethodCreate;
import br.edu.ufersa.masterSkewb.api.dtos.methods.MethodPatch;
import br.edu.ufersa.masterSkewb.api.dtos.methods.MethodResponse;
import br.edu.ufersa.masterSkewb.api.dtos.methods.MethodUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/metodos")
public class MethodController {
    @GetMapping
    public ResponseEntity<List<MethodResponse>> list(){
        return null;
    }

    @GetMapping("/{methodId}")
    public ResponseEntity<MethodResponse> findById (@PathVariable long methodId){
        return null;
    }

    @PostMapping
    public ResponseEntity<MethodResponse> create(@RequestBody MethodCreate dto){
        return null;
    }

    @PutMapping("/{methodId}")
    public ResponseEntity<MethodResponse> update(
            @PathVariable long methodId,
            @RequestBody MethodUpdate dto) {
        return null;
    }

    @PatchMapping("/{methodId}")
    public ResponseEntity<MethodResponse> patch(
            @PathVariable long methodId,
            @RequestBody MethodPatch dto) {
        return null;
    }

    @DeleteMapping("/{methodId}")
    public ResponseEntity<Void> delete(@PathVariable long methodId) {
        return null;
    }
}
