package Server;

import java.util.HashMap;

public class AuthenticationManager {
    // Manages the authentification process
    // Handles verification of user credentials

    private HashMap<Integer, String> userCredentials;

    public AuthenticationManager() {
        userCredentials = new HashMap<>();
        userCredentials.put(1, "password1");
        userCredentials.put(2, "password2");
    }

    public boolean authenticate(int studentNumber, String password){
        return (userCredentials.containsKey(studentNumber) && userCredentials.get(studentNumber).equals(password));
    }
}
