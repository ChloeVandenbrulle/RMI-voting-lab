package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject {
    // Registers remote objects in the RMI registry
    private Registry rmiServer;
    private ObjectDistant object = new ObjectDistant(10001);
    private boolean readOnlyMode = false;


    protected ServerImpl() throws RemoteException {
    }

    public void startServer() {
        try {
            rmiServer = LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://localhost:2001/MyObj", object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        if (readOnlyMode) {
            try {
                object.getResult();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setReadOnlyMode(boolean readOnly) {
        readOnlyMode = readOnly;
        object.setServerReadOnly(readOnly);
    }

}
