package Server;

import Client.Authentication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjectDistant extends UnicastRemoteObject implements Distant {
    protected ObjectDistant(int port) throws RemoteException {
        super(port);
    }

    @Override
    public boolean authenticationManager(int studentNumber, String password) throws RemoteException {
        AuthenticationManager authenticationManager = new AuthenticationManager();
        return authenticationManager.authenticate(studentNumber, password);
    }
}
