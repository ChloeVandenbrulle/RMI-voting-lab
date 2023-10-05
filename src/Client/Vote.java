package Client;

import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Vote extends Remote {
    // Provides methods for the user to cast their vote
    void requestVotingMaterials(User user) throws RemoteException;
    void vote(int candidateNumber, int rank, int studentNumber, int otp) throws RemoteException;
    boolean hasAlreadyVoted(int studentNumber) throws RemoteException;

}
