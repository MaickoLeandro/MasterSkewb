package br.edu.ufersa.masterSkewb.features.users;

import br.edu.ufersa.masterSkewb.features.valueObjects.Email;
import br.edu.ufersa.masterSkewb.features.valueObjects.Name;
import br.edu.ufersa.masterSkewb.features.valueObjects.Password;

import java.util.Objects;

public class User {
    private long id;
    private Name name;
    private Email email;
    private Password password;

    public User(long id, Name name, Email email, Password password){
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
    }

    public Email getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }
}
