package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {
    Authentication getAuthentication() throws RemoteException;
    Vote getVote() throws RemoteException;
    void displayResults() throws RemoteException;
}
