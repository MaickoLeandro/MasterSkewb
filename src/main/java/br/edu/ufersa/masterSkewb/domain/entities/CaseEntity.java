package br.edu.ufersa.masterSkewb.domain.entities;

import br.edu.ufersa.masterSkewb.domain.valueObjects.Name;
import br.edu.ufersa.masterSkewb.domain.valueObjects.StateId;

public class CaseEntity {
    private long id;
    private Name name;
    private StateId stateId;
    private Method method;

    public CaseEntity(long id, Name name, StateId stateId, Method method) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
        this.method = method;
    }

    public long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public StateId getStateId() {
        return stateId;
    }

    public Method getMethod() {
        return method;
    }
}
