package Server;

import java.util.HashMap;
import java.util.Map;

public class VotingManager {
    // Manages the voting process
    // Generates and sends One Time Password to users

    private Map<Integer, Boolean> hasVoted;
    private Map<Integer, Integer> otp;

    public VotingManager() {
        hasVoted = new HashMap<>();
        otp = new HashMap<>();
    }

    public boolean checkOTP(int studentNumber, int otpUser){
        return (otp.containsKey(studentNumber) && otp.get(studentNumber).equals(otpUser));
    }

    public boolean checkHasVoted(int studentNumber){
        return (hasVoted.containsKey(studentNumber) && hasVoted.get(studentNumber));
    }

    public void markedHasVoted(int studentNumber){
        hasVoted.put(studentNumber, true);
    }

    public void resetHasVoted(int studentNumber){
        hasVoted.put(studentNumber, false);
    }
}
