package Server;

import Client.CandidateDisplay;
import Client.Vote;

import java.io.Serializable;

public class VotingMaterial implements Serializable {
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private CandidateDisplay candidateDisplay;
    private Vote vote;
    private int OTP;

    public VotingMaterial(CandidateDisplay candidateDisplay, Vote vote, int OTP) {
        this.candidateDisplay = candidateDisplay;
        this.vote = vote;
        this.OTP = OTP;
    }

    public CandidateDisplay getCandidateDisplay() {
        return candidateDisplay;
    }

    public Vote getVote() {
        return vote;
    }

    public int getOTP() {
        return OTP;
    }
}
