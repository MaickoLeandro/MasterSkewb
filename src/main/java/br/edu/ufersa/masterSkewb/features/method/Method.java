package br.edu.ufersa.masterSkewb.features.method;

import br.edu.ufersa.masterSkewb.features.valueObjects.Name;

public class Method {
    private long id;
    private Name name;

    public Method(long id, Name name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }
}
