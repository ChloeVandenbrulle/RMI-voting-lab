package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    // Registers remote objects in the RMI registry
    // Provides methods to interact with clients

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        ObjectDistant object = new ObjectDistant(10001);

        Registry rmiServer = LocateRegistry.createRegistry(2001);

        Naming.rebind("rmi://localhost::2001/MyObj", object);
    }


}
