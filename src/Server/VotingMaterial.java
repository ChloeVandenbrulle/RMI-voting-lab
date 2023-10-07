package Server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;

public class VotingMaterial implements Serializable {
    // Generates and sends the One Time Password and the candidates' information to users
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private List<Candidate> candidates;
    private List<User> users;

    public VotingMaterial(DataStorage dataStorage, int studentNumber) {
        this.candidates = dataStorage.getAllCandidates();
        users = dataStorage.getAllUsers();
    }

    public List<User> getUsers() {
        return users;
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
