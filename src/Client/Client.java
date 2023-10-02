package Client;

import Server.Distant;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, InterruptedException {
        try {
            Distant client = (Distant) Naming.lookup("rmi://localhost:2001/MyObj");


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
