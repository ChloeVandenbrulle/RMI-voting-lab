package Server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class VoteRecord implements Serializable {
    // Represents a record of users votes, including the candidates voted for
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private int studentNumber;
    private Map<Integer, Integer> votes;    // Map<Rank, candidateNumber>

    public VoteRecord(int studentNumber) {
        this.studentNumber = studentNumber;
        this.votes = new HashMap<>();
    }

    public void addVote(int rank, int candidateNumber){
        votes.put(rank, candidateNumber);
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public Map<Integer, Integer> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "VoteRecord{" +
                "studentNumber=" + studentNumber +
                ", votes=" + votes +
                '}';
    }
}
