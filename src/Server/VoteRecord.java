package Server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class VoteRecord implements Serializable {
    // Represents a record of users votes, including the candidates voted for
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private int studentNumber;
    private Map<Integer, Integer> vote;    // Map<Rank, candidateNumber>

    public VoteRecord(int studentNumber) {
        this.studentNumber = studentNumber;
        this.vote = new HashMap<>();
    }

    public void addVote(int rank, int candidateNumber){
        vote.put(rank, candidateNumber);
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public Map<Integer, Integer> getVote() {
        return vote;
    }

    @Override
    public String toString() {
        return "VoteRecord{" +
                "studentNumber=" + studentNumber +
                ", vote=" + vote +
                '}';
    }
}
