import Client.Authentication;
import Server.AuthenticationManager;
import Server.Candidate;
import Server.User;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Pour lancer le serveur, entrez \"start\"");
        String start = scanner.nextLine();
        if ("start".equalsIgnoreCase(start)){
        }
    }
}