package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjectDistant extends UnicastRemoteObject implements Distant {

    protected ObjectDistant(int port) throws RemoteException {
        super(port);
    }




}
