package Server;

import Client.Authentication;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager implements Authentication, Serializable {
    // Manages the authentification process
    // Handles verification of user credentials
    private Map<Integer, User> userCredentials;
    public AuthenticationManager(DataStorage dataStorage) {
        userCredentials = dataStorage.getUsers();

        System.out.println("ça marche");
    }

    @Override
    public boolean authenticate(int studentNumber, String password) throws RemoteException {
        return (userCredentials.containsKey(studentNumber) && userCredentials.get(studentNumber).getPassword().equals(password));
    }
}
