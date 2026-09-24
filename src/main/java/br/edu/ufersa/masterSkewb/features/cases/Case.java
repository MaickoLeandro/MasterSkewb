package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;
import jakarta.persistence.*;


@Entity
@Table(name = "case")
class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private Name name;
    @Embedded
    private StateId stateId;
    private long methodId;

    public Case() {}

    public Case(long id, Name name, StateId stateId, long methodId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
        this.methodId = methodId;
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

    public long getMethodId() {
        return methodId;
    }
}
