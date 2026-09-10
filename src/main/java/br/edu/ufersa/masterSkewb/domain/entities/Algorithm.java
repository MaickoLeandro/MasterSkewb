package br.edu.ufersa.masterSkewb.domain.entities;

public class Algorithm {
    private long id;
    private User user;
    private CaseEntity caseEntity;

    public Algorithm(long id, User user, CaseEntity caseEntity){
        this.id = id;
        this.user = validarUser(user);
        this.caseEntity = validarCaseEntity(caseEntity);
    }

    private User validarUser(User user){
        if(user == null)
            throw new IllegalArgumentException("Usuário não pode ser vazio");
        return user;
    }

    private CaseEntity validarCaseEntity(CaseEntity caseEntity){
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

    public CaseEntity getCaseEntity() {
        return caseEntity;
    }
}
