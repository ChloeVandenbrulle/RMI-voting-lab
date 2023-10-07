package Client;

import Server.Distant;
import Server.VoteRecord;

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
                System.out.println("Vous êtes identifié !");
                if (client.getOTPUser(studentNumber)!=-1){
                    System.out.println("Vous avez déjà voté!");
                    System.out.println("Voulez-vous revoter ?");
                    String revoter = reader.readLine();
                    if (revoter.toLowerCase().equals("oui")){
                        client.setUserForRevote(studentNumber);
                    }
                }
                System.out.println(client.canVote(studentNumber));
                if (client.canVote(studentNumber)){
                    int trueOTP = client.sendOTP(studentNumber);
                    System.out.println("Voici votre OTP : " + trueOTP);
                    System.out.println(client.sendCandidates(studentNumber));
                    int otp = 0;
                    VoteRecord voteRecord = new VoteRecord(studentNumber);
                    System.out.println("Entrez le numéro du candidat puis appuyer sur \"Entrer\"" +
                            " puis entrez le rang que vous voulez lui associer entre 0 et 3 (0: très insuffisant, 3:parfait).\nEntrez votre otp une fois que vous avez fini de voter.");
                    while (otp!=trueOTP) {
                        System.out.println("Candidat : ");
                        int candidateNumber = scanner.nextInt();
                        if (candidateNumber==trueOTP){
                            break;
                        }
                        System.out.println("Rang : ");
                        int rank = scanner.nextInt();
                        if (rank==trueOTP){
                            break;
                        }
                        voteRecord.addVote(candidateNumber, rank);
                    }
                    System.out.println(voteRecord.toString());
                    client.retrieveVote(voteRecord, studentNumber);
                    client.getResult();
                }
            } else {
                System.out.println("Erreur lors de l'identification. \nVotre numéro étudiant ou votre mot de passe est incorect.");
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
