package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import jakarta.persistence.*;



@Entity
class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Name name;

    public Method(long id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Method() {

    }

    public long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }
}
