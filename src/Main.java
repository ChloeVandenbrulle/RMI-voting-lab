import Client.Authentication;
import Server.AuthenticationManager;
import Server.Candidate;
import Server.User;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        System.out.println("Hello world!");
        Candidate candidate = new Candidate(1, "Robert", "Hello");
        System.out.println(candidate);
        AuthenticationManager authenticationManager = new AuthenticationManager();
        System.out.println(authenticationManager.authenticate(1, "password2"));
    }
}