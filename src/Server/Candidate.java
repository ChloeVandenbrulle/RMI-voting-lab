package Server;

import java.io.Serializable;

public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private int candidateNumber;
    private String name;
    private String pitch;

    public Candidate(int candidateNumber, String name, String pitch) {
        this.candidateNumber = candidateNumber;
        this.name = name;
        this.pitch = pitch;
    }

    public int getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(int candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    @Override
    public String toString() {
        return "Candidate " + candidateNumber +
                " : " + name +
                "\npitch: " + pitch;
    }
}
