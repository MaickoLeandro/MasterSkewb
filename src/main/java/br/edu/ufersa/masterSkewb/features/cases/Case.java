package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.method.Method;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;

public class Case {
    private long id;
    private Name name;
    private StateId stateId;
    private Method method;

    public Case(long id, Name name, StateId stateId, Method method) {
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
