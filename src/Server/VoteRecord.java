package Server;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class VoteRecord implements Serializable {
    // Represents a record of users votes, including the candidates voted for
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private int studentNumber;
    private String date;
    private Map<Integer, Integer> vote;    // Map<candidateNumber, Rank>

    public VoteRecord(int studentNumber) {
        this.studentNumber = studentNumber;
        this.vote = new HashMap<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);
    }

    public void addVote(int candidateNumber, int rank){
        vote.put(candidateNumber,rank);
    }

    public String getDate() {
        return date;
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
                "numéro d'étudiant=" + studentNumber +
                ", vote=" + vote +
                ", date du vote= " + date +
                '}';
    }
}
