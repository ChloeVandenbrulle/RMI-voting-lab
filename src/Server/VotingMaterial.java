package Server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;

public class VotingMaterial implements Serializable {
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private List<Candidate> candidates;
    private List<User> usersWithoutOTP;

    public VotingMaterial(DataStorage dataStorage, int studentNumber) {
        this.candidates = dataStorage.getAllCandidates();
        usersWithoutOTP = dataStorage.getAllUsers();

    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public List<User> getUsersWithoutOTP() {
        return usersWithoutOTP;
    }

    public void setUsersWithoutOTP(List<User> usersWithoutOTP) {
        this.usersWithoutOTP = usersWithoutOTP;
    }

    public void generateOTP(User user) {
        Random random =  new Random();
        int OTP = 100+random.nextInt(900);
        user.setOTP(OTP);
    }

    public String displayCandidates() throws RemoteException {
        String phrase = "Liste des candidats :\n";

        for (Candidate candidate: candidates){
            phrase += candidate.toString() + "\n";
        }
        return phrase;
    }
}
