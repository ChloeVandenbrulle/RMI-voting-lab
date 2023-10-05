package Client;

import Server.Candidate;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CandidateDisplay extends UnicastRemoteObject {
    // Display candidates information
    private List<Candidate> candidates;

    public CandidateDisplay(List<Candidate> candidates) throws RemoteException {
        this.candidates = candidates;
    }

    public void displayCandidates() throws RemoteException {
        System.out.println("Liste des candidats :");
        for (Candidate candidate: candidates){
            System.out.println(candidate.toString());
        }
    }
}
