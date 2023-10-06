package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Server {
    // Registers remote objects in the RMI registry
    // Provides methods to interact with clients

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            ServerImpl server = new ServerImpl();
            boolean serverRunning = true;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Pour lancer le serveur, entrez \"start\"");
            System.out.println("Pour arreter le serveur, entrez \"stop\"");
            while (serverRunning){
                String start = scanner.nextLine();

                switch (start.toLowerCase()){
                    case "start":
                        server.startServer();
                        System.out.println("Mise en route du serveur. Le vote peut commencer!");
                        break;
                    case "stop":
                        server.stopServer();
                        System.out.println("Arrêt du serveur. Le vote est terminé!");
                        break;
                    default:
                        System.out.println("Mauvaise saisie.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
