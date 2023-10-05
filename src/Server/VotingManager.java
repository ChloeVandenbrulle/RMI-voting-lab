package Server;

import Client.CandidateDisplay;
import Client.Vote;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VotingManager implements Vote {
    // Manages the voting process
    // Generates and sends One Time Password to users

    private Map<Integer, Boolean> hasVoted;
    private Map<Integer, Integer> otp;
    private Map<Integer, VotingMaterial> votingMaterials;

    public VotingManager() {
        hasVoted = new HashMap<>();
        otp = new HashMap<>();
        votingMaterials = new HashMap<>();
    }

    public boolean checkOTP(int studentNumber, int otpUser){
        return (otp.containsKey(studentNumber) && otp.get(studentNumber).equals(otpUser));
    }

    public void markedHasVoted(int studentNumber){
        hasVoted.put(studentNumber, true);
    }

    public void resetHasVoted(int studentNumber){
        hasVoted.put(studentNumber, false);
    }

    public int generateOTP(int studentNumber) {
        Random random =  new Random();
        int OTP = 100+random.nextInt(900);
        otp.put(studentNumber, OTP);
        return OTP;
    }

    @Override
    public void requestVotingMaterials(User user) throws RemoteException {
       int studentNumber = user.getStudentNumber();
       if(!hasVoted.containsKey(studentNumber) && !otp.containsKey(studentNumber)){
           int otpStudent = generateOTP(studentNumber);
           otp.put(studentNumber, otpStudent);
       }

    }

    @Override
    public void vote(int candidateNumber, int rank, int studentNumber, int otp) throws RemoteException {

    }

    @Override
    public boolean hasAlreadyVoted(int studentNumber) throws RemoteException {
        return (hasVoted.containsKey(studentNumber) && hasVoted.get(studentNumber));
    }
}
