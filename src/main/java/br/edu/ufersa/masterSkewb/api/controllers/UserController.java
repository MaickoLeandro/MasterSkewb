package br.edu.ufersa.masterSkewb.api.controllers;

import br.edu.ufersa.masterSkewb.api.dtos.users.UserCreate;
import br.edu.ufersa.masterSkewb.api.dtos.users.UserPatch;
import br.edu.ufersa.masterSkewb.api.dtos.users.UserResponse;
import br.edu.ufersa.masterSkewb.api.dtos.users.UserUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {
    @GetMapping
    public ResponseEntity<List<UserResponse>> list(){
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findById (@PathVariable long userId){
        return null;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserCreate dto){
        return null;
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> update(
            @PathVariable long userId,
            @RequestBody UserUpdate dto) {
        return null;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponse> patch(
            @PathVariable long userId,
            @RequestBody UserPatch dto) {
        return null;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable long userId) {
        return null;
    }
}