package br.edu.ufersa.masterSkewb.features.algorithm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Algorithm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long caseId;
    private Moves moves;

    public Algorithm() {}

    public Algorithm(long id,long userId, long caseId,  Moves moves) {
        this.id = id;
        this.userId = userId;
        this.caseId = caseId;
        this.moves = moves;
    }



    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getCaseId() {
        return caseId;
    }

    public Moves getMoves() {
        return moves;
    }
}
