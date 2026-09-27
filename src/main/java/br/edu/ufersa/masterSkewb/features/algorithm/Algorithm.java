package br.edu.ufersa.masterSkewb.features.algorithm;

import br.edu.ufersa.masterSkewb.features.valueObjects.Moves;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table (name = "algorithm")
class Algorithm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @NotNull
    private Long caseId;
    @Embedded
    private Moves moves;

    public Algorithm() {}

    public Algorithm(Long id,Long userId, Long caseId, Moves moves) {
        this.id = id;
        this.userId = userId;
        this.caseId = caseId;
        this.moves = moves;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public Moves getMoves() {
        return moves;
    }
}
