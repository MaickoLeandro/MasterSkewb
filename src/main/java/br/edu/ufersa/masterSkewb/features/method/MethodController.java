package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.method.dtos.MethodCreate;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodResponse;
import br.edu.ufersa.masterSkewb.features.method.dtos.MethodUpdate;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/metodos")
@Validated
public class MethodController {
    private final MethodApplicationService methodApplicationService;

    public MethodController(MethodApplicationService methodApplicationService) {
        this.methodApplicationService = methodApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<MethodResponse>> list(){
        return ResponseEntity.ok(methodApplicationService.getMethods());
    }

    @GetMapping("/{methodId}")
    public ResponseEntity<MethodResponse> findById (@PathVariable Long methodId){
        return ResponseEntity.ok(methodApplicationService.getMethodById(methodId));
    }

    @PostMapping
    public ResponseEntity<MethodResponse> create(@RequestBody @Valid MethodCreate dto,
                                                 UriComponentsBuilder uriBuilder){
        MethodResponse salvo = methodApplicationService.createMethod(dto);
        URI uri = uriBuilder
                .path("/api/v1/metodos/{methodId}")
                .buildAndExpand(salvo.id())
                .toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @PutMapping("/{methodId}")
    public ResponseEntity<MethodResponse> update(
            @PathVariable Long methodId,
            @RequestBody @Valid MethodUpdate dto) {
        return ResponseEntity.ok(methodApplicationService.updateMethod(methodId, dto));
    }


    @DeleteMapping("/{methodId}")
    public ResponseEntity<Void> delete(@PathVariable Long methodId) {
        methodApplicationService.deleteMethodById(methodId);

        return ResponseEntity.ok().build();
    }
}
