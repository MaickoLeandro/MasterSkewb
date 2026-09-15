package br.edu.ufersa.masterSkewb.features.algorithm;

import br.edu.ufersa.masterSkewb.features.cases.Case;
import br.edu.ufersa.masterSkewb.features.users.User;

public class Algorithm {
    private long id;
    private User user;
    private Case caseEntity;

    public Algorithm(long id, User user, Case caseEntity){
        this.id = id;
        this.user = validarUser(user);
        this.caseEntity = validarCaseEntity(caseEntity);
    }

    private User validarUser(User user){
        if(user == null)
            throw new IllegalArgumentException("Usuário não pode ser vazio");
        return user;
    }

    private Case validarCaseEntity(Case caseEntity){
        if(user == null){
            throw new IllegalArgumentException("Caso não pode ser vazio");
        }
        return caseEntity;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Case getCaseEntity() {
        return caseEntity;
    }
}
