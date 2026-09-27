package br.edu.ufersa.masterSkewb.features.algorithm;

import br.com.javaskewb.core.Cube.State;
import br.com.javaskewb.core.Mapping.Moves.AdvancedMoves;
import br.com.javaskewb.core.Mapping.Moves.Moves;
import br.com.javaskewb.core.utils.StateRank;
import br.edu.ufersa.masterSkewb.features.algorithm.exceptions.InvalidMovesException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class AlgorithmDomainService {
    private final List<State> solvedStates = State.generatePerspectivesStates(State.getSolvedState());
    private final Moves moves = new AdvancedMoves();

    public String validateAlgorithm(String sequence, Long stateId){
        Set<String> notation = moves.getNotation().keySet();
        List<String> algorithm = Arrays.stream(sequence.split(" ")).toList();

        for (String move : algorithm) {
            if (!notation.contains(move)) {
                throw new InvalidMovesException(move + " não é um movimento válido");
            }
        }

        State state = StateRank.createState(stateId);
        moves.setState(state);
        moves.setUpdateState(true);

        StringBuilder stringBuilder = new StringBuilder();
        for (String move : algorithm){
            moves.applyMove(move);
            stringBuilder.append(move).append(" ");

            if (solvedStates.contains(state)){
                return stringBuilder.toString().trim();
            }
        }

        return null;
    }
}
