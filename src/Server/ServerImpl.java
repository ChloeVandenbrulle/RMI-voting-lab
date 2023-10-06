package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject {
    private Registry rmiServer;

    protected ServerImpl() throws RemoteException {
    }

    public void startServer() {
        try {
            ObjectDistant object = new ObjectDistant(10001);
            rmiServer = LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://localhost:2001/MyObj", object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        try {
            UnicastRemoteObject.unexportObject(rmiServer, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
