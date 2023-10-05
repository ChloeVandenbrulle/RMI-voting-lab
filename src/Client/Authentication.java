package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Authentication extends Remote {
    // Handles user authentication and receives OTP from the server

    boolean authenticate(int studentNumber, String password) throws RemoteException;

}
