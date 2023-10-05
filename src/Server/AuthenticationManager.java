package Server;

import Client.Authentication;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;

public class AuthenticationManager implements Authentication, Serializable {
    // Manages the authentification process
    // Handles verification of user credentials

    private HashMap<Integer, String> userCredentials;

    public AuthenticationManager() {
        userCredentials = new HashMap<>();
        userCredentials.put(1, "password1");
        userCredentials.put(2, "password2");
        System.out.println("ça marche");
    }

    @Override
    public boolean authenticate(int studentNumber, String password) throws RemoteException {
        return (userCredentials.containsKey(studentNumber) && userCredentials.get(studentNumber).equals(password));
    }
}
