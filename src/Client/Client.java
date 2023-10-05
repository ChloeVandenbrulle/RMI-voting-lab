package Client;

import Server.Distant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.Buffer;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, InterruptedException {
        try {
            System.out.println("Entrez votre numéro étudiant : ");
            Scanner scanner = new Scanner(System.in);
            int studentNumber = scanner.nextInt();
            System.out.println("Entrez votre mot de passe : ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String password = reader.readLine();

            Distant client = (Distant) Naming.lookup("rmi://localhost:2001/MyObj");
            if (client.authenticationManager(studentNumber, password)){
                System.out.println("Vous êtes identifiés !");
            } else {
                System.out.println("Erreur lors de l'identification. \nVotre numéro étudiant ou votre mot de passe est incorect.");
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
