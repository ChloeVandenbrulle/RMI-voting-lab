package Client;

import Server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Vote extends Remote {
    // Provides methods for the user to cast their vote
    boolean canVote(int studentNumber) throws RemoteException;

}
