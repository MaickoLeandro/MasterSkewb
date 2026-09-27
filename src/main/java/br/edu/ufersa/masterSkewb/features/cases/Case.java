package br.edu.ufersa.masterSkewb.features.cases;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.StateId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "cases")
class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Name name;
    @Embedded
    private StateId stateId;
    @NotNull
    private Long methodId;

    public Case() {}

    public Case(Long id, Name name, StateId stateId, long methodId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
        this.methodId = methodId;
    }



    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public StateId getStateId() {
        return stateId;
    }

    public Long getMethodId() {
        return methodId;
    }
}
