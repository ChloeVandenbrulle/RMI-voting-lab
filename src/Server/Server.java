package Server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Server {
    // Provides methods to interact with clients

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            ServerImpl server = new ServerImpl();
            boolean serverRunning = true;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Pour lancer le vote, entrez \"start\"");
            System.out.println("Pour arreter le vote, entrez \"stop\"");
            while (serverRunning){
                String start = scanner.nextLine();

                switch (start.toLowerCase()){
                    case "start":
                        server.startServer();
                        System.out.println("Mise en route du serveur. Le vote peut commencer!");
                        break;
                    case "stop":
                        server.setReadOnlyMode(true);
                        System.out.println("Arrêt du serveur. Le vote est terminé!");
                        server.stopServer();
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
