package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Authentication extends Remote {
    // Handles user authentication

    boolean authenticate(int studentNumber, String password) throws RemoteException;

}
