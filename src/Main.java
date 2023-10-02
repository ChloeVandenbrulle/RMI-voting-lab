import Client.Authentication;
import Server.AuthenticationManager;
import Server.Candidate;
import Server.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Candidate candidate = new Candidate(1, "Robert", "Hello");
        System.out.println(candidate);
        AuthenticationManager authenticationManager = new AuthenticationManager();
        System.out.println(authenticationManager.authenticate(1, "password2"));
    }
}